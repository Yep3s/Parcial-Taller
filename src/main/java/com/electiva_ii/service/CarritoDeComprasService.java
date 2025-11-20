package com.electiva_ii.service;

import com.electiva_ii.dto.request.CarritoDeComprasRequest;
import com.electiva_ii.dto.request.ProductoCarritoDeComprasRequest;
import com.electiva_ii.dto.response.CarritoDeComprasResponse;
import com.electiva_ii.mapper.CarritoDeComprasMapper;
import com.electiva_ii.model.CarritoDeCompras;
import com.electiva_ii.model.Producto;
import com.electiva_ii.model.Usuario;
import com.electiva_ii.repository.CarritoDeComprasRepository;
import com.electiva_ii.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarritoDeComprasService {

    private final CarritoDeComprasRepository carritoDeComprasRepository;
    private final ProductoRepository productoRepository;
    private final CarritoDeComprasMapper carritoDeComprasMapper;

    @Transactional
    public CarritoDeComprasResponse crearCarritoDeCompras(Usuario usuario, CarritoDeComprasRequest request) {
        List<Integer> productoIds = extractProductoIds(request);
        Map<Integer, Producto> productoMap = loadProductosAsMap(productoIds);

        List<Producto> productosCarrito = new ArrayList<>();
        double subtotal = calcularSubtotalYActualizarStock(request, productoMap, productosCarrito);

        productoRepository.saveAll(productoMap.values());

        double impuestos = calcularImpuestos(subtotal);

        CarritoDeCompras carrito = CarritoDeCompras.builder()
                .usuario(usuario)
                .productos(productosCarrito)
                .subtotal(subtotal)
                .impuestos(impuestos)
                .build();

        carritoDeComprasRepository.save(carrito);

        return carritoDeComprasMapper.mapCarritoDeComprasResponse(carrito);
    }

    public List<CarritoDeComprasResponse> listarCarritosDeComprasUsuario(Usuario usuario) {
        return carritoDeComprasRepository
                .findByUsuario(usuario)
                .stream()
                .map(carritoDeComprasMapper::mapCarritoDeComprasResponse)
                .toList();
    }

    private List<Integer> extractProductoIds(CarritoDeComprasRequest request) {
        return request.getProductos()
                .stream()
                .map(ProductoCarritoDeComprasRequest::getIdProducto)
                .toList();
    }

    private Map<Integer, Producto> loadProductosAsMap(List<Integer> ids) {
        return productoRepository.findAllById(ids)
                .stream()
                .collect(Collectors.toMap(Producto::getIdProducto, p -> p));
    }

    private double calcularSubtotalYActualizarStock(CarritoDeComprasRequest request, Map<Integer, Producto> productoMap, List<Producto> productosCarrito) {
        double subtotal = 0;

        for (ProductoCarritoDeComprasRequest pReq : request.getProductos()) {

            Producto producto = productoMap.get(pReq.getIdProducto());

            if (producto == null) {
                throw new IllegalArgumentException("Producto con ID " + pReq.getIdProducto() + " no encontrado");
            }

            if (producto.getStock() < pReq.getCantidad()) {
                throw new IllegalArgumentException(
                        "Producto " + producto.getNombre() + " sin stock suficiente"
                );
            }

            producto.setStock(producto.getStock() - pReq.getCantidad());

            productosCarrito.addAll(
                    java.util.Collections.nCopies(pReq.getCantidad(), producto)
            );

            subtotal += producto.getPrecio() * pReq.getCantidad();
        }

        return subtotal;
    }

    private double calcularImpuestos(double subtotal) {
        return subtotal * 0.17;
    }

}

package com.electiva_ii.service;

import com.electiva_ii.dto.request.OrdenDeCompraRequest;
import com.electiva_ii.dto.response.OrdenDeCompraResponse;
import com.electiva_ii.mapper.OrdenDeCompraMapper;
import com.electiva_ii.model.CarritoDeCompras;
import com.electiva_ii.model.OrdenDeCompra;
import com.electiva_ii.model.Usuario;
import com.electiva_ii.repository.CarritoDeComprasRepository;
import com.electiva_ii.repository.OrdenDeCompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdenDeCompraService {

    private final OrdenDeCompraRepository ordenDeCompraRepository;
    private final CarritoDeComprasRepository carritoDeComprasRepository;
    private final OrdenDeCompraMapper ordenDeCompraMapper;

    public OrdenDeCompraResponse crearOrdenDeCompra(Usuario usuario, OrdenDeCompraRequest request) {
        CarritoDeCompras carrito = obtenerCarritoValido(usuario, request.getIdCarrito());

        double subtotal = carrito.getSubtotal();
        double impuestos = carrito.getImpuestos();
        double envio = request.getEnvio();
        double total = calcularTotal(subtotal, impuestos, envio);

        OrdenDeCompra orden = construirOrden(usuario, carrito, subtotal, impuestos, envio, total);

        ordenDeCompraRepository.save(orden);

        return ordenDeCompraMapper.mapOrdenDeCompraResponse(orden);
    }

    public List<OrdenDeCompraResponse> listarOrdenesDeCompra(Usuario usuario) {
        return ordenDeCompraRepository.findByUsuario(usuario)
                .stream()
                .map(ordenDeCompraMapper::mapOrdenDeCompraResponse)
                .collect(Collectors.toList());
    }

    private CarritoDeCompras obtenerCarritoValido(Usuario usuario, int carritoId) {
        CarritoDeCompras carrito = carritoDeComprasRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        if (carrito.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
            throw new RuntimeException("El carrito no pertenece al usuario logueado");
        }

        return carrito;
    }

    private double calcularTotal(double subtotal, double impuestos, double envio) {
        return subtotal + impuestos + envio;
    }

    private OrdenDeCompra construirOrden(Usuario usuario, CarritoDeCompras carrito, double subtotal, double impuestos, double envio, double total) {
        return OrdenDeCompra.builder()
                .usuario(usuario)
                .productos(new ArrayList<>(carrito.getProductos()))
                .subtotal(subtotal)
                .impuestos(impuestos)
                .envio(envio)
                .total(total)
                .build();
    }

}

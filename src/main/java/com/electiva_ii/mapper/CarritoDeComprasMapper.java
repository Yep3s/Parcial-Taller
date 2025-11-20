package com.electiva_ii.mapper;

import com.electiva_ii.dto.response.CarritoDeComprasResponse;
import com.electiva_ii.dto.response.ProductoCarritoDeComprasResponse;
import com.electiva_ii.model.CarritoDeCompras;
import com.electiva_ii.model.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CarritoDeComprasMapper {

    public CarritoDeComprasResponse mapCarritoDeComprasResponse(CarritoDeCompras carrito) {

        Map<Integer, Long> cantidadMap = carrito.getProductos().stream()
                .collect(Collectors.groupingBy(Producto::getIdProducto, Collectors.counting()));

        List<ProductoCarritoDeComprasResponse> productos = carrito.getProductos().stream()
                .distinct()
                .map(p -> ProductoCarritoDeComprasResponse.builder()
                        .idProducto(p.getIdProducto())
                        .nombre(p.getNombre())
                        .precio(p.getPrecio())
                        .cantidad(cantidadMap.get(p.getIdProducto()).intValue())
                        .stock(p.getStock())
                        .build())
                .collect(Collectors.toList());

        return CarritoDeComprasResponse.builder()
                .idCarrito(carrito.getIdCarrito())
                .productos(productos)
                .subtotal(carrito.getSubtotal())
                .impuestos(carrito.getImpuestos())
                .build();
    }

}

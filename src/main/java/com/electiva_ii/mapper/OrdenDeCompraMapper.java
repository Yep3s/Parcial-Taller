package com.electiva_ii.mapper;

import com.electiva_ii.dto.response.OrdenDeCompraResponse;
import com.electiva_ii.dto.response.ProductoOrdenDeCompraResponse;
import com.electiva_ii.model.OrdenDeCompra;
import com.electiva_ii.model.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrdenDeCompraMapper {

    public OrdenDeCompraResponse mapOrdenDeCompraResponse(OrdenDeCompra orden) {
        Map<Integer, Long> cantidadMap = orden.getProductos().stream()
                .collect(Collectors.groupingBy(Producto::getIdProducto, Collectors.counting()));

        List<ProductoOrdenDeCompraResponse> productos = orden.getProductos().stream()
                .distinct()
                .map(p -> ProductoOrdenDeCompraResponse.builder()
                        .idProducto(p.getIdProducto())
                        .nombre(p.getNombre())
                        .precio(p.getPrecio())
                        .cantidad(cantidadMap.get(p.getIdProducto()).intValue())
                        .build())
                .collect(Collectors.toList());

        return OrdenDeCompraResponse.builder()
                .idOrden(orden.getIdOrden())
                .productos(productos)
                .subtotal(orden.getSubtotal())
                .impuestos(orden.getImpuestos())
                .envio(orden.getEnvio())
                .total(orden.getTotal())
                .build();
    }

}

package com.electiva_ii.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarritoDeComprasResponse {
    private int idCarrito;
    private List<ProductoCarritoDeComprasResponse> productos;
    private double subtotal;
    private double impuestos;
}

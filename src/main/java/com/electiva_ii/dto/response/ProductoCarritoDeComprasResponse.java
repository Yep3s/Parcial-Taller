package com.electiva_ii.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoCarritoDeComprasResponse {
    private int idProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    private int stock;
}

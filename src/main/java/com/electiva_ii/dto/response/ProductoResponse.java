package com.electiva_ii.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoResponse {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
}

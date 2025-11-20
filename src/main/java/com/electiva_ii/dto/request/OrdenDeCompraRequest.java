package com.electiva_ii.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrdenDeCompraRequest {
    private int idCarrito;
    private double envio;
}

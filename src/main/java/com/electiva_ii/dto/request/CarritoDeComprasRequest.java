package com.electiva_ii.dto.request;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarritoDeComprasRequest {
    private List<ProductoCarritoDeComprasRequest> productos;
}

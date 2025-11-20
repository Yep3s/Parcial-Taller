package com.electiva_ii.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoRequest {
    private int stockMax;
}

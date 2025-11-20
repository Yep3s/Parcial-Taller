package com.electiva_ii.dto.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ComentariosRequest {
    private LocalDate fechaDesde;
}

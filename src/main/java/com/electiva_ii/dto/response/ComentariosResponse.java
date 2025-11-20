package com.electiva_ii.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ComentariosResponse {
    private int idComentario;
    private String producto;
    private String usuario;
    private String comentario;
    private LocalDateTime fecha;
}

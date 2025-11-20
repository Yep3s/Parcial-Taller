package com.electiva_ii.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequest {
    private String correoElectronico;
    private String contraseña;
}

package com.electiva_ii.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {
    private String token;
}

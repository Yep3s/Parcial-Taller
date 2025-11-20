package com.electiva_ii.jwt;

import com.electiva_ii.model.Usuario;
import com.electiva_ii.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUserService {

    private final UsuarioRepository usuarioRepository;

    public Usuario getAuthenticatedUser() {
        String correoElectronico = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return usuarioRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado"));
    }

}

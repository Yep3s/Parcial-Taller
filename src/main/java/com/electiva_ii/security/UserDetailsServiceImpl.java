package com.electiva_ii.security;

import com.electiva_ii.model.Usuario;
import com.electiva_ii.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getCorreoElectronico())
                .password(usuario.getContraseña())
                .build();
    }

}

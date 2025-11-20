package com.electiva_ii.repository;

import com.electiva_ii.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}

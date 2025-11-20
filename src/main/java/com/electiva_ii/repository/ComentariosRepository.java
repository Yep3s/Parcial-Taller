package com.electiva_ii.repository;

import com.electiva_ii.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ComentariosRepository extends JpaRepository<Comentarios, Integer> {
    List<Comentarios> findByFechaAfter(LocalDateTime fecha);
}

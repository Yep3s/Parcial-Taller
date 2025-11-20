package com.electiva_ii.repository;

import com.electiva_ii.model.CarritoDeCompras;
import com.electiva_ii.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoDeComprasRepository extends JpaRepository<CarritoDeCompras, Integer> {
    List<CarritoDeCompras> findByUsuario(Usuario usuario);
}

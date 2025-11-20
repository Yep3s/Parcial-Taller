package com.electiva_ii.repository;

import com.electiva_ii.model.OrdenDeCompra;
import com.electiva_ii.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {
    List<OrdenDeCompra> findByUsuario(Usuario usuario);
}

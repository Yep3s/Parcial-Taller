package com.electiva_ii.repository;

import com.electiva_ii.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByStockLessThan(int stock);
}

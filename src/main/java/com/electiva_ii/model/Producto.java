package com.electiva_ii.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

}

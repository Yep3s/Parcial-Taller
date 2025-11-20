package com.electiva_ii.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarritoDeCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "CarritoDeProductos",
            joinColumns = @JoinColumn(name = "idCarritoDeCompras", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idProducto", nullable = false)
    )
    private List<Producto> productos;

    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double impuestos;
}

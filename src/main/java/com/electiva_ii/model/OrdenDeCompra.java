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
public class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;

    @ManyToMany
    @JoinTable(
            name = "OrdenDeProductos",
            joinColumns = @JoinColumn(name = "idOrdenDeCompra", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idProducto", nullable = false)
    )
    private List<Producto> productos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double impuestos;

    @Column(nullable = false)
    private double envio;

    @Column(nullable = false)
    private double total;

}

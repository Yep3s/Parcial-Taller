package com.electiva_ii.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String comentario;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha;

}

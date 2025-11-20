package com.electiva_ii.model;

import com.electiva_ii.model.enums.MetodoDePago;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @JsonIgnore
    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoDePago metodoDePago;

}

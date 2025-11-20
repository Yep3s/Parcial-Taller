package com.electiva_ii.config;

import com.electiva_ii.model.Usuario;
import com.electiva_ii.repository.UsuarioRepository;
import com.electiva_ii.model.enums.MetodoDePago;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (usuarioRepository.count() == 0) {

            usuarioRepository.save(Usuario.builder()
                    .nombre("Juan Pérez")
                    .correoElectronico("juan.perez@email.com")
                    .contraseña(passwordEncoder.encode("Qwerty123"))
                    .direccion("Carrera 45 #10-20")
                    .metodoDePago(MetodoDePago.TARJETA_CREDITO)
                    .build());

            usuarioRepository.save(Usuario.builder()
                    .nombre("Ana Gómez")
                    .correoElectronico("ana.gomez@email.com")
                    .contraseña(passwordEncoder.encode("Pass456"))
                    .direccion("Calle 21 #35-50")
                    .metodoDePago(MetodoDePago.PAYPAL)
                    .build());

            usuarioRepository.save(Usuario.builder()
                    .nombre("Carlos Ruiz")
                    .correoElectronico("carlos.ruiz@email.com")
                    .contraseña(passwordEncoder.encode("Segura789"))
                    .direccion("Avenida Principal #100")
                    .metodoDePago(MetodoDePago.TRANSFERENCIA_BANCARIA)
                    .build());

            usuarioRepository.save(Usuario.builder()
                    .nombre("Sofía Martínez")
                    .correoElectronico("sofia.martinez@email.com")
                    .contraseña(passwordEncoder.encode("Clave987"))
                    .direccion("Calle 8 #20-30")
                    .metodoDePago(MetodoDePago.EFECTIVO)
                    .build());

            usuarioRepository.save(Usuario.builder()
                    .nombre("Diego Fernández")
                    .correoElectronico("diego.fernandez@email.com")
                    .contraseña(passwordEncoder.encode("Contra654"))
                    .direccion("Carrera 77 #40-60")
                    .metodoDePago(MetodoDePago.TARJETA_DEBITO)
                    .build());

        }

    }

}
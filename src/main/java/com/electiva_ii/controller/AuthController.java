package com.electiva_ii.controller;

import com.electiva_ii.dto.request.AuthRequest;
import com.electiva_ii.dto.response.AuthResponse;
import com.electiva_ii.jwt.JwtUtil;
import com.electiva_ii.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getCorreoElectronico(),
                request.getContraseña()
        );

        authenticationManager.authenticate(auth);

        UserDetails user = userDetailsService.loadUserByUsername(request.getCorreoElectronico());

        String token = jwtUtil.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token));
    }

}

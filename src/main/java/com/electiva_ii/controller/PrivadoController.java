package com.electiva_ii.controller;

import com.electiva_ii.dto.request.CarritoDeComprasRequest;
import com.electiva_ii.dto.request.OrdenDeCompraRequest;
import com.electiva_ii.dto.response.CarritoDeComprasResponse;
import com.electiva_ii.dto.response.OrdenDeCompraResponse;
import com.electiva_ii.jwt.JwtUserService;
import com.electiva_ii.model.Usuario;
import com.electiva_ii.service.CarritoDeComprasService;
import com.electiva_ii.service.OrdenDeCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/privado")
public class PrivadoController {

    private final CarritoDeComprasService carritoDeCompraService;
    private final OrdenDeCompraService ordenDeCompraService;
    private final JwtUserService jwtUserService;

    @PostMapping("/crear-carrito-compras")
    public CarritoDeComprasResponse crearCarritoDeCompras(@RequestBody CarritoDeComprasRequest request) {
        Usuario usuario = jwtUserService.getAuthenticatedUser();
        return carritoDeCompraService.crearCarritoDeCompras(usuario, request);
    }

    @GetMapping("/listar-carritos-compras")
    public List<CarritoDeComprasResponse> listarCarritosDeCompras() {
        Usuario usuario = jwtUserService.getAuthenticatedUser();
        return carritoDeCompraService.listarCarritosDeComprasUsuario(usuario);
    }

    @PostMapping("/crear-orden-compra")
    public OrdenDeCompraResponse crearOrdenDeCompra(@RequestBody OrdenDeCompraRequest request) {
        Usuario usuario = jwtUserService.getAuthenticatedUser();
        return ordenDeCompraService.crearOrdenDeCompra(usuario, request);
    }

    @GetMapping("/listar-ordenes-compra")
    public List<OrdenDeCompraResponse> listarOrdenesDeCompra() {
        Usuario usuario = jwtUserService.getAuthenticatedUser();
        return ordenDeCompraService.listarOrdenesDeCompra(usuario);
    }

}

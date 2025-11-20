package com.electiva_ii.controller;

import com.electiva_ii.dto.request.ComentariosRequest;
import com.electiva_ii.dto.request.ProductoRequest;
import com.electiva_ii.dto.response.ComentariosResponse;
import com.electiva_ii.dto.response.ProductoResponse;
import com.electiva_ii.model.Comentarios;
import com.electiva_ii.model.Producto;
import com.electiva_ii.repository.ComentariosRepository;
import com.electiva_ii.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publico")
public class PublicoController {

    private final ProductoRepository productoRepository;
    private final ComentariosRepository comentariosRepository;

    @PostMapping("/listar-productos")
    public List<ProductoResponse> listarProductos(@RequestBody ProductoRequest request) {
        List<Producto> productos = productoRepository.findByStockLessThan(request.getStockMax());
        return productos.stream()
                .map(p -> ProductoResponse.builder()
                        .idProducto(p.getIdProducto())
                        .nombre(p.getNombre())
                        .descripcion(p.getDescripcion())
                        .precio(p.getPrecio())
                        .stock(p.getStock())
                        .categoria(p.getCategoria().getNombre())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/listar-comentarios")
    public List<ComentariosResponse> listarComentarios(@RequestBody ComentariosRequest request) {
        LocalDateTime fechaDesde = request.getFechaDesde().atStartOfDay();
        List<Comentarios> comentarios = comentariosRepository.findByFechaAfter(fechaDesde);
        return comentarios.stream()
                .map(c -> ComentariosResponse.builder()
                        .idComentario(c.getIdComentario())
                        .producto(c.getProducto().getNombre())
                        .usuario(c.getUsuario().getNombre())
                        .comentario(c.getComentario())
                        .fecha(c.getFecha())
                        .build())
                .collect(Collectors.toList());
    }

}

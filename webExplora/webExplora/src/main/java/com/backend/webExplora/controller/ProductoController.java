package com.backend.webExplora.controller;

import com.backend.webExplora.dto.entrada.ProductoEntradaDto;
import com.backend.webExplora.dto.salida.ProductoSalidaDto;
import com.backend.webExplora.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin (origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productos")
@Validated
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/aleatorios")
    public ResponseEntity<List<ProductoSalidaDto>> obtenerProductosAleatorios() {
        List<ProductoSalidaDto> productos = productoService.obtenerProductosAleatorios();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalidaDto> obtenerDetalleProducto(@PathVariable Long id) {
        ProductoSalidaDto producto = productoService.obtenerDetalleProducto(id);
        return ResponseEntity.ok(producto);
    }
}

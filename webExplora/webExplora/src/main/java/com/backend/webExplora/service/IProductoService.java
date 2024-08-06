package com.backend.webExplora.service;

import com.backend.webExplora.dto.salida.ProductoSalidaDto;

import java.util.List;
public interface IProductoService {
    List<ProductoSalidaDto> obtenerProductosAleatorios();
    ProductoSalidaDto obtenerDetalleProducto(Long id);
}

package com.backend.webExplora.service.impl;

import com.backend.webExplora.dto.salida.ProductoSalidaDto;
import com.backend.webExplora.entity.Producto;
import com.backend.webExplora.repository.ProductoRepository;
import com.backend.webExplora.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoSalidaDto> obtenerProductosAleatorios() {
        logger.info("Obteniendo lista de productos aleatorios");
        List<Producto> productos = productoRepository.findAll();
        Collections.shuffle(productos);
        return productos.stream().limit(10)
                .map(producto -> modelMapper.map(producto, ProductoSalidaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoSalidaDto obtenerDetalleProducto(Long id) {
        logger.info("Obteniendo detalles del producto con id: {}", id);
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return modelMapper.map(producto, ProductoSalidaDto.class);
    }
}

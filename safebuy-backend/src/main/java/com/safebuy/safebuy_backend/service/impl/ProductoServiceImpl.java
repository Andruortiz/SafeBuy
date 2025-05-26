package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Producto;
import com.safebuy.safebuy_backend.repository.ProductoRepository;
import com.safebuy.safebuy_backend.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setDescripcion(productoActualizado.getDescripcion());
                    producto.setPrecio(productoActualizado.getPrecio());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}

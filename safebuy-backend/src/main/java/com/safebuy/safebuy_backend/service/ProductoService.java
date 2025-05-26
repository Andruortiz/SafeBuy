package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto crearProducto(Producto producto);
    List<Producto> obtenerTodos();
    Optional<Producto> buscarPorId(Long id);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}

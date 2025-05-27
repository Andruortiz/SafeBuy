package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    List<Categoria> obtenerTodas();
    Optional<Categoria> buscarPorId(Long id);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
}

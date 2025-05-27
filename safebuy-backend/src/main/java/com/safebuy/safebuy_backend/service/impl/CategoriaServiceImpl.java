package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Categoria;
import com.safebuy.safebuy_backend.repository.CategoriaRepository;
import com.safebuy.safebuy_backend.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria nueva) {
        return categoriaRepository.findById(id)
                .map(c -> {
                    c.setNombre(nueva.getNombre());
                    c.setDetalleCategoria(nueva.getDetalleCategoria());
                    c.setProductos(nueva.getProductos());
                    return categoriaRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

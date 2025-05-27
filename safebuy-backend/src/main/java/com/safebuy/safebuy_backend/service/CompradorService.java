package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Comprador;

import java.util.List;
import java.util.Optional;

public interface CompradorService {
    Comprador crearComprador(Comprador comprador);
    List<Comprador> obtenerTodos();
    Optional<Comprador> buscarPorId(Long id);
    Comprador actualizarComprador(Long id, Comprador comprador);
    void eliminarComprador(Long id);
}

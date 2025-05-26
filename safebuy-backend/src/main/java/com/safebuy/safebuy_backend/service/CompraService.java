package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraService {
    Compra crearCompra(Compra compra);
    List<Compra> obtenerTodas();
    Optional<Compra> buscarPorId(Long id);
    Compra actualizarCompra(Long id, Compra compra);
    void eliminarCompra(Long id);
}

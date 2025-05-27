package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {
    Vendedor crearVendedor(Vendedor vendedor);
    List<Vendedor> obtenerTodos();
    Optional<Vendedor> buscarPorId(Long id);
    Vendedor actualizarVendedor(Long id, Vendedor vendedor);
    void eliminarVendedor(Long id);
}

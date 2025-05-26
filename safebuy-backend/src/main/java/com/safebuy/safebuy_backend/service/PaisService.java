package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService {
    Pais crearPais(Pais pais);
    List<Pais> obtenerTodos();
    Optional<Pais> buscarPorId(String id);
    Pais actualizarPais(String id, Pais pais);
    void eliminarPais(String id);
    boolean estaHabilitadoParaTransaccion(String id);
}

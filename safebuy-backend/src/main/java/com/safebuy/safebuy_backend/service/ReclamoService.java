package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Reclamo;

import java.util.List;
import java.util.Optional;

public interface ReclamoService {
    Reclamo crearReclamo(Reclamo reclamo);
    List<Reclamo> obtenerTodos();
    Optional<Reclamo> buscarPorId(Long id);
    Reclamo actualizarReclamo(Long id, Reclamo reclamo);
    void eliminarReclamo(Long id);
    Reclamo responderReclamo(Long id, String respuesta);
}

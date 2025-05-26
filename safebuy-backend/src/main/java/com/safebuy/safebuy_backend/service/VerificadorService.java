package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Verificador;

import java.util.List;
import java.util.UUID;

public interface VerificadorService {
    Verificador crearVerificacion(Verificador verificador);
    Verificador actualizarEstado(UUID id);
    List<Verificador> obtenerTodas();
}

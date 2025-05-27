package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Moneda;

import java.util.List;
import java.util.Optional;

public interface MonedaService {
    Moneda registrarMoneda(Moneda moneda);
    List<Moneda> obtenerTodas();
    Optional<Moneda> buscarPorId(Long id);
    Moneda actualizarMoneda(Long id, Moneda moneda);
    void eliminarMoneda(Long id);
}

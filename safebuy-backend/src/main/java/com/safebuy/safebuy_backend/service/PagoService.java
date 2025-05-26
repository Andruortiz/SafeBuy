package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {
    Pago registrarPago(Pago pago);
    List<Pago> obtenerPagos();
    Optional<Pago> buscarPagoPorId(Long id);
    Pago actualizarPago(Long id, Pago pago);
    void eliminarPago(Long id);
}

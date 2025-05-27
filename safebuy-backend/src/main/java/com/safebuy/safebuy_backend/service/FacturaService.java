package com.safebuy.safebuy_backend.service;

import com.safebuy.safebuy_backend.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    Factura crearFactura(Factura factura);
    List<Factura> obtenerFacturas();
    Optional<Factura> buscarPorId(Long id);
    Factura actualizarFactura(Long id, Factura factura);
    void eliminarFactura(Long id);
}

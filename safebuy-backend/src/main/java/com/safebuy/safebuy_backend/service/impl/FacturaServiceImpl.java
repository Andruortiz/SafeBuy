package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Factura;
import com.safebuy.safebuy_backend.repository.FacturaRepository;
import com.safebuy.safebuy_backend.service.FacturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public List<Factura> obtenerFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> buscarPorId(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura actualizarFactura(Long id, Factura nuevaFactura) {
        return facturaRepository.findById(id)
                .map(f -> {
                    f.setDetalles(nuevaFactura.getDetalles());
                    f.setCompra(nuevaFactura.getCompra());
                    return facturaRepository.save(f);
                })
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}

package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Pago;
import com.safebuy.safebuy_backend.repository.PagoRepository;
import com.safebuy.safebuy_backend.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> buscarPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago actualizarPago(Long id, Pago nuevoPago) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pago.setMonto(nuevoPago.getMonto());
                    pago.setMoneda(nuevoPago.getMoneda());
                    pago.setCompra(nuevoPago.getCompra());
                    return pagoRepository.save(pago);
                })
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    @Override
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}

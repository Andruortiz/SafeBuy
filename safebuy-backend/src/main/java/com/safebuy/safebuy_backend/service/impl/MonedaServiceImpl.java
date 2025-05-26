package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Moneda;
import com.safebuy.safebuy_backend.repository.MonedaRepository;
import com.safebuy.safebuy_backend.service.MonedaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    private final MonedaRepository monedaRepository;

    public MonedaServiceImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public Moneda registrarMoneda(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public List<Moneda> obtenerTodas() {
        return monedaRepository.findAll();
    }

    @Override
    public Optional<Moneda> buscarPorId(Long id) {
        return monedaRepository.findById(id);
    }

    @Override
    public Moneda actualizarMoneda(Long id, Moneda nueva) {
        return monedaRepository.findById(id)
                .map(m -> {
                    m.setCodigo(nueva.getCodigo());
                    m.setNombre(nueva.getNombre());
                    m.setPais(nueva.getPais());
                    return monedaRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Moneda no encontrada"));
    }

    @Override
    public void eliminarMoneda(Long id) {
        monedaRepository.deleteById(id);
    }
}

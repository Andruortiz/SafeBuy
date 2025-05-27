package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Comprador;
import com.safebuy.safebuy_backend.repository.CompradorRepository;
import com.safebuy.safebuy_backend.service.CompradorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;

    public CompradorServiceImpl(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @Override
    public Comprador crearComprador(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    @Override
    public List<Comprador> obtenerTodos() {
        return compradorRepository.findAll();
    }

    @Override
    public Optional<Comprador> buscarPorId(Long id) {
        return compradorRepository.findById(id);
    }

    @Override
    public Comprador actualizarComprador(Long id, Comprador nuevo) {
        return compradorRepository.findById(id)
                .map(c -> {
                    c.setCompras(nuevo.getCompras());
                    return compradorRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Comprador no encontrado"));
    }

    @Override
    public void eliminarComprador(Long id) {
        compradorRepository.deleteById(id);
    }
}

package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Reclamo;
import com.safebuy.safebuy_backend.repository.ReclamoRepository;
import com.safebuy.safebuy_backend.service.ReclamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoServiceImpl implements ReclamoService {

    private final ReclamoRepository reclamoRepository;

    public ReclamoServiceImpl(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    @Override
    public Reclamo crearReclamo(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    @Override
    public List<Reclamo> obtenerTodos() {
        return reclamoRepository.findAll();
    }

    @Override
    public Optional<Reclamo> buscarPorId(Long id) {
        return reclamoRepository.findById(id);
    }

    @Override
    public Reclamo actualizarReclamo(Long id, Reclamo nuevoReclamo) {
        return reclamoRepository.findById(id)
                .map(reclamo -> {
                    reclamo.setMotivo(nuevoReclamo.getMotivo());
                    reclamo.setEstado(nuevoReclamo.getEstado());
                    reclamo.setRespuesta(nuevoReclamo.getRespuesta());
                    reclamo.setCompra(nuevoReclamo.getCompra());
                    return reclamoRepository.save(reclamo);
                })
                .orElseThrow(() -> new RuntimeException("Reclamo no encontrado"));
    }

    @Override
    public void eliminarReclamo(Long id) {
        reclamoRepository.deleteById(id);
    }

    @Override
    public Reclamo responderReclamo(Long id, String respuesta) {
        return reclamoRepository.findById(id)
                .map(reclamo -> {
                    reclamo.setRespuesta(respuesta);
                    return reclamoRepository.save(reclamo);
                })
                .orElseThrow(() -> new RuntimeException("Reclamo no encontrado"));
    }
}

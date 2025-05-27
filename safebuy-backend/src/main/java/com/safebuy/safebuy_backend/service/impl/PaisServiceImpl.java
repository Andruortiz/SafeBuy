package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Pais;
import com.safebuy.safebuy_backend.repository.PaisRepository;
import com.safebuy.safebuy_backend.service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public Pais crearPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> obtenerTodos() {
        return paisRepository.findAll();
    }

    @Override
    public Optional<Pais> buscarPorId(String id) {
        return paisRepository.findById(id);
    }

    @Override
    public Pais actualizarPais(String id, Pais paisActualizado) {
        return paisRepository.findById(id)
                .map(pais -> {
                    pais.setNombrePais(paisActualizado.getNombrePais());
                    pais.setCodigoISO(paisActualizado.getCodigoISO());
                    pais.setMoneda(paisActualizado.getMoneda());
                    pais.setActivoTransaccion(paisActualizado.getActivoTransaccion());
                    return paisRepository.save(pais);
                })
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
    }

    @Override
    public void eliminarPais(String id) {
        paisRepository.deleteById(id);
    }

    @Override
    public boolean estaHabilitadoParaTransaccion(String id) {
        return paisRepository.findById(id)
                .map(p -> "habilitado".equalsIgnoreCase(p.getActivoTransaccion()))
                .orElse(false);
    }
}

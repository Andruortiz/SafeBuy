package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Verificador;
import com.safebuy.safebuy_backend.repository.VerificadorRepository;
import com.safebuy.safebuy_backend.service.VerificadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VerificadorServiceImpl implements VerificadorService {

    private final VerificadorRepository verificadorRepository;

    public VerificadorServiceImpl(VerificadorRepository verificadorRepository) {
        this.verificadorRepository = verificadorRepository;
    }

    @Override
    public Verificador crearVerificacion(Verificador verificador) {
        verificador.validarEstado();
        return verificadorRepository.save(verificador);
    }

    @Override
    public Verificador actualizarEstado(UUID id) {
        Verificador v = verificadorRepository.findById(id).orElseThrow();
        v.validarEstado();
        return verificadorRepository.save(v);
    }

    @Override
    public List<Verificador> obtenerTodas() {
        return verificadorRepository.findAll();
    }
}

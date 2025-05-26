package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Compra;
import com.safebuy.safebuy_backend.repository.CompraRepository;
import com.safebuy.safebuy_backend.service.CompraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra crearCompra(Compra compra) {
        // Aquí podrías sumar precios o validar detalles antes de guardar
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> buscarPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public Compra actualizarCompra(Long id, Compra nuevaCompra) {
        return compraRepository.findById(id)
                .map(compra -> {
                    compra.setDetalle(nuevaCompra.getDetalle());
                    compra.setPrecioTotal(nuevaCompra.getPrecioTotal());
                    compra.setComprador(nuevaCompra.getComprador() );
                    return compraRepository.save(compra);
                })
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}

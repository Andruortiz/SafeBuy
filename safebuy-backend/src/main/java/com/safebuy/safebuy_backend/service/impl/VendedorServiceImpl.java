package com.safebuy.safebuy_backend.service.impl;

import com.safebuy.safebuy_backend.entity.Vendedor;
import com.safebuy.safebuy_backend.repository.VendedorRepository;
import com.safebuy.safebuy_backend.service.VendedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorServiceImpl(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public Vendedor crearVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        return vendedorRepository.findAll();
    }

    @Override
    public Optional<Vendedor> buscarPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    @Override
    public Vendedor actualizarVendedor(Long id, Vendedor nuevo) {
        return vendedorRepository.findById(id)
                .map(v -> {
                    v.setDetalleVendedor(nuevo.getDetalleVendedor());
                    v.setProductos(nuevo.getProductos());
                    return vendedorRepository.save(v);
                })
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

    @Override
    public void eliminarVendedor(Long id) {
        vendedorRepository.deleteById(id);
    }
}

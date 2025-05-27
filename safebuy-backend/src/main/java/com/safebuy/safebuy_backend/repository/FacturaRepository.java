package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}

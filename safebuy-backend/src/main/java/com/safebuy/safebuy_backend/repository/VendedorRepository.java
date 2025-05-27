package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}

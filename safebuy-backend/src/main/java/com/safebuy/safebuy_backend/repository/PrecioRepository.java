package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecioRepository extends JpaRepository<Precio, Long> {
}

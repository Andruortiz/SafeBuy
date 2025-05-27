package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

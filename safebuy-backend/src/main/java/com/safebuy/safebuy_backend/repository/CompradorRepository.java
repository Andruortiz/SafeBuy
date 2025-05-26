package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}

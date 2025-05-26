package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}

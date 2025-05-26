package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

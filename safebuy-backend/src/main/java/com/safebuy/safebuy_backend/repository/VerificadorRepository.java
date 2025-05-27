package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Verificador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerificadorRepository extends JpaRepository<Verificador, UUID> {
    Optional<Verificador> findByCombinacionUnica(String combinacionUnica);
}

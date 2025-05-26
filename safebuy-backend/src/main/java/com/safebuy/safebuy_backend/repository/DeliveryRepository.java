package com.safebuy.safebuy_backend.repository;

import com.safebuy.safebuy_backend.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

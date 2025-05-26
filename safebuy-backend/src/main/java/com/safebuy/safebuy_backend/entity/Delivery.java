package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaEnvio;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleDelivery> detalle = new ArrayList<>();

    public Delivery() {
        this.fechaEnvio = LocalDate.now();
        this.detalle = new ArrayList<>();
    }

    public Delivery(LocalDate fechaEnvio, List<DetalleDelivery> detalle) {
        this.fechaEnvio = fechaEnvio;
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public List<DetalleDelivery> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleDelivery> detalle) {
        this.detalle = detalle;
    }
}

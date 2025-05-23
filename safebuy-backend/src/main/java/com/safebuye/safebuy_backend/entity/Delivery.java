package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Temporal(TemporalType.DATE)
    private Date fechaEnvio = new Date();

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleDelivery> detalles = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Delivery() {
        this.fechaEnvio = new Date();
        this.detalles = new ArrayList<>();
    }

    public Delivery(Date fechaEnvio, List<DetalleDelivery> detalles) {
        this.fechaEnvio = (fechaEnvio != null) ? fechaEnvio : new Date();
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = (fechaEnvio != null) ? fechaEnvio : new Date();
    }

    public List<DetalleDelivery> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleDelivery> detalles) {
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Delivery ejecutando operación logística.");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión Delivery: " + texto;
    }
}

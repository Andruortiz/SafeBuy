package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public final class Motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";

    private boolean activo = true;

    // ------------------------
    // Constructores
    // ------------------------

    public Motivo() {
        this.nombre = "";
        this.activo = true;
    }

    public Motivo(String nombre, boolean activo) {
        this.nombre = (nombre != null) ? nombre : "";
        this.activo = activo;
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null) ? nombre : "";
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Ejecutando lógica sobre Motivo...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

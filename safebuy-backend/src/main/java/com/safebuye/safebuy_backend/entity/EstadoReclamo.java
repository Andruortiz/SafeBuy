package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public final class EstadoReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";
    private String estado = "";

    // ------------------------
    // Constructores
    // ------------------------

    public EstadoReclamo() {
        this.nombre = "";
        this.estado = "";
    }

    public EstadoReclamo(String nombre, String estado) {
        this.nombre = (nombre != null) ? nombre : "";
        this.estado = (estado != null) ? estado : "";
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = (estado != null) ? estado : "";
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Lógica ejecutada desde EstadoReclamo...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false)
    private boolean activo;

    public MetodoPago() {
        this.nombre = "";
        this.activo = true;
    }

    public MetodoPago(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

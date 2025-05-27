package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String nombre;

    private boolean activo;

    public Motivo() {
        this.nombre = "";
        this.activo = true;
    }

    public Motivo(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public UUID getId() {
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

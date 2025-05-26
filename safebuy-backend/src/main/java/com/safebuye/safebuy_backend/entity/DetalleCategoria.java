package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class DetalleCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String condiciones;

    public DetalleCategoria() {
        this.descripcion = "";
        this.condiciones = "";
    }

    public DetalleCategoria(String descripcion, String condiciones) {
        this.descripcion = descripcion;
        this.condiciones = condiciones;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }
}

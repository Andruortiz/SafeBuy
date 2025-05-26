package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class DetalleEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private boolean entregado;

    public DetalleEntrega() {
        this.descripcion = "";
        this.entregado = false;
    }

    public DetalleEntrega(String descripcion, boolean entregado) {
        this.descripcion = descripcion;
        this.entregado = entregado;
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

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}

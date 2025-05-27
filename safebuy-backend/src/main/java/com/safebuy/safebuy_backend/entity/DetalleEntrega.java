package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class DetalleEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

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

    public UUID getId() {
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

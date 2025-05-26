package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class EstadoReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String estado;

    public EstadoReclamo() {
        this.nombre = "";
        this.estado = "inactivo";
    }

    public EstadoReclamo(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

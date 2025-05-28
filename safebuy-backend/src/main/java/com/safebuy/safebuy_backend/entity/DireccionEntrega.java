package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class DireccionEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String direccion;
    private String referencia;

    @ManyToOne
    private Ciudad ciudad;

    public DireccionEntrega() {
        this.direccion = "";
        this.referencia = "";
    }

    public DireccionEntrega(String direccion, String referencia, Ciudad ciudad) {
        this.direccion = direccion;
        this.referencia = referencia;
        this.ciudad = ciudad;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}

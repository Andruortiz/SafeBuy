package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String codigo;
    private String nombre;

    @OneToOne(mappedBy = "moneda")
    private Pais pais;

    public Moneda() {
        this.codigo = "";
        this.nombre = "";
    }

    public Moneda(String codigo, String nombre, Pais pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public UUID getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // Funcionales
    public boolean esValida() {
        return !codigo.isBlank() && !nombre.isBlank();
    }

    public static String formatearCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) throw new IllegalArgumentException("Código vacío.");
        return codigo.trim().toUpperCase();
    }
}

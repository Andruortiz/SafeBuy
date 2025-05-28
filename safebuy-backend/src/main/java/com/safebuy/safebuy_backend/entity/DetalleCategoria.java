package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class DetalleCategoria {

    @Id
    @GeneratedValue
    private UUID id;

    private String descripcionProducto;
    private String subcategoria;

    public DetalleCategoria() {
        this.descripcionProducto = "";
        this.subcategoria = "";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}
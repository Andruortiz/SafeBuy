package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Compra
    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras = new ArrayList<>();

    public Comprador() {
        this.compras = new ArrayList<>();
    }

    public Comprador(List<Compra> compras) {
        this.compras = compras;
    }

    public Long getId() {
        return id;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    // Método funcional
    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }
}

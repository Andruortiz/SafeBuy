package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con DetalleCompra
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalle = new ArrayList<>();

    @ManyToOne(optional = false)
    private Precio precioTotal;

    @ManyToOne(optional = false)
    private Comprador comprador;

    public Compra() {
        this.detalle = new ArrayList<>();
    }

    public Compra(List<DetalleCompra> detalle, Precio precioTotal, Comprador comprador) {
        this.detalle = detalle;
        this.precioTotal = precioTotal;
        this.comprador = comprador;
    }

    public Long getId() {
        return id;
    }

    public List<DetalleCompra> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleCompra> detalle) {
        this.detalle = detalle;
    }

    public Precio getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Precio precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void agregarDetalle(DetalleCompra dc) {
        this.detalle.add(dc);
    }
}

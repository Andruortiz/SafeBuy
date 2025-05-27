package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class VendedorProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double reputacion;
    private int ventasTotales;

    public VendedorProducto() {
        this.reputacion = 0.0;
        this.ventasTotales = 0;
    }

    public VendedorProducto(double reputacion, int ventasTotales) {
        this.reputacion = reputacion;
        this.ventasTotales = ventasTotales;
    }

    public Long getId() {
        return id;
    }

    public double getReputacion() {
        return reputacion;
    }

    public void setReputacion(double reputacion) {
        this.reputacion = reputacion;
    }

    public int getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(int ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    // Método funcional
    public boolean esVendedorConfiable() {
        return reputacion >= 4.0 && ventasTotales > 10;
    }
}

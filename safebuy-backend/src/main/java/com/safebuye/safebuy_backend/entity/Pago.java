package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(optional = false)
    private Moneda moneda;

    @ManyToOne(optional = false)
    private Compra compra;

    public Pago() {
        this.monto = 0.0;
        this.estado = "pendiente";
    }

    public Pago(double monto, String estado, Moneda moneda, Compra compra) {
        this.monto = monto;
        this.estado = estado;
        this.moneda = moneda;
        this.compra = compra;
    }

    public Long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}

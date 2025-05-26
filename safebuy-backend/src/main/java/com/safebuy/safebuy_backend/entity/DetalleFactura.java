package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concepto;
    private int cantidad;
    private BigDecimal subtotal;

    @ManyToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
        this.concepto = "";
        this.cantidad = 0;
        this.subtotal = BigDecimal.ZERO;
    }

    public DetalleFactura(String concepto, int cantidad, BigDecimal subtotal, Factura factura) {
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
    }

    public Long getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}

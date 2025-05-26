package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @ManyToOne(optional = false)
    private Compra compra;

    public DetalleCompra() {
        this.producto = new Producto();
        this.cantidad = 0;
        this.subtotal = BigDecimal.ZERO;
    }

    public DetalleCompra(Producto producto, int cantidad, BigDecimal subtotal, Compra compra) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.compra = compra;
    }

    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}

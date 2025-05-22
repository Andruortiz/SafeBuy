package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto = new Producto(); // Nunca null

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra = new Compra(); // Relación inversa con Compra

    private int cantidad = 0;

    private BigDecimal subtotal = BigDecimal.ZERO;

    // ------------------------
    // Constructores
    // ------------------------

    public DetalleCompra() {
        this.producto = new Producto();
        this.cantidad = 0;
        this.subtotal = BigDecimal.ZERO;
    }

    public DetalleCompra(Producto producto, int cantidad, BigDecimal subtotal, Compra compra) {
        this.producto = (producto != null) ? producto : new Producto();
        this.cantidad = cantidad;
        this.subtotal = (subtotal != null) ? subtotal : BigDecimal.ZERO;
        this.compra = (compra != null) ? compra : new Compra();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = (producto != null) ? producto : new Producto();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = (compra != null) ? compra : new Compra();
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
        this.subtotal = (subtotal != null) ? subtotal : BigDecimal.ZERO;
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Ejecutando acción desde DetalleCompra...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}


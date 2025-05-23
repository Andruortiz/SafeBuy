package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class VendedorProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private double reputacion = 0.0;

    private int ventasTotales = 0;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor = new Vendedor();

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto = new Producto();

    // ------------------------
    // Constructores
    // ------------------------

    public VendedorProducto() {
        this.reputacion = 0.0;
        this.ventasTotales = 0;
        this.vendedor = new Vendedor();
        this.producto = new Producto();
    }

    public VendedorProducto(double reputacion, int ventasTotales, Vendedor vendedor, Producto producto) {
        this.reputacion = reputacion;
        this.ventasTotales = ventasTotales;
        this.vendedor = (vendedor != null) ? vendedor : new Vendedor();
        this.producto = (producto != null) ? producto : new Producto();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = (vendedor != null) ? vendedor : new Vendedor();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = (producto != null) ? producto : new Producto();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("VendedorProducto ejecutando lógica...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

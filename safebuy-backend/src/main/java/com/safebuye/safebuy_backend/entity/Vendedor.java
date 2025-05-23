package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendedorProducto> productosVendedor = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Vendedor() {
        this.nombre = "";
        this.productosVendedor = new ArrayList<>();
    }

    public Vendedor(String nombre) {
        this.nombre = (nombre != null) ? nombre : "";
        this.productosVendedor = new ArrayList<>();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null) ? nombre : "";
    }

    public List<VendedorProducto> getProductosVendedor() {
        return productosVendedor;
    }

    public void setProductosVendedor(List<VendedorProducto> productosVendedor) {
        this.productosVendedor = (productosVendedor != null) ? productosVendedor : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Lógica de vendedor ejecutada...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Valor inválido para imprimir.";
        }
        return "Impresión: " + texto;
    }
}

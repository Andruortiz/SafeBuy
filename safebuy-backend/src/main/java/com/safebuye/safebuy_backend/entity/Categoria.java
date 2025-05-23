package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCategoria> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "detalleCategoria.categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Categoria() {
        this.nombre = "";
        this.detalles = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public Categoria(String nombre, List<DetalleCategoria> detalles, List<Producto> productos) {
        this.nombre = (nombre != null) ? nombre : "";
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
        this.productos = (productos != null) ? productos : new ArrayList<>();
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

    public List<DetalleCategoria> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCategoria> detalles) {
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = (productos != null) ? productos : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Categoria ejecutando lógica...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

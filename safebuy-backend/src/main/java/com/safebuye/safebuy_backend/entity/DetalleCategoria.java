package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DetalleCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String descripcion = "";

    private String condiciones = "";

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria = new Categoria();

    @OneToMany(mappedBy = "detalleCategoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public DetalleCategoria() {
        this.descripcion = "";
        this.condiciones = "";
        this.categoria = new Categoria();
        this.productos = new ArrayList<>();
    }

    public DetalleCategoria(String descripcion, String condiciones, Categoria categoria) {
        this.descripcion = (descripcion != null) ? descripcion : "";
        this.condiciones = (condiciones != null) ? condiciones : "";
        this.categoria = (categoria != null) ? categoria : new Categoria();
        this.productos = new ArrayList<>();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion : "";
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = (condiciones != null) ? condiciones : "";
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = (categoria != null) ? categoria : new Categoria();
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
        System.out.println("DetalleCategoria en ejecución...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

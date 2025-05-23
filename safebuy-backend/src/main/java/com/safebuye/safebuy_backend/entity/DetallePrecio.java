package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class DetallePrecio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String descripcion = "";

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto = new Producto();

    @ManyToOne
    @JoinColumn(name = "precio_id", nullable = false)
    private Precio precio = new Precio();

    // -------------------
    // Constructores
    // -------------------

    public DetallePrecio() {
        this.descripcion = "";
    }

    public DetallePrecio(String descripcion, Producto producto, Precio precio) {
        this.descripcion = (descripcion != null) ? descripcion : "";
        this.producto = (producto != null) ? producto : new Producto();
        this.precio = (precio != null) ? precio : new Precio();
    }

    // -------------------
    // Getters y Setters
    // -------------------

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion : "";
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = (producto != null) ? producto : new Producto();
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = (precio != null) ? precio : new Precio();
    }

    // -------------------
    // Métodos funcionales
    // -------------------

    public void hacerAlgo() {
        System.out.println("DetallePrecio ejecutando operación.");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) return "Texto inválido.";
        return "DetallePrecio: " + texto;
    }
}

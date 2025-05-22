package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";

    private String descripcion = "";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "precio_id", referencedColumnName = "id")
    private Precio precio = new Precio(); // Nunca null

    // ------------------------
    // Constructores
    // ------------------------

    public Producto() {
        this.nombre = "";
        this.descripcion = "";
        this.precio = new Precio();
    }

    public Producto(String nombre, String descripcion, Precio precio) {
        this.nombre = (nombre != null) ? nombre : "";
        this.descripcion = (descripcion != null) ? descripcion : "";
        this.precio = (precio != null) ? precio : new Precio();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion : "";
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = (precio != null) ? precio : new Precio();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Producto realizando acción...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

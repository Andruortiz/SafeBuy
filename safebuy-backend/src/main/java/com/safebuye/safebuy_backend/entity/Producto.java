package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String nombre = "";
    private String descripcion = "";

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Precio precio = new Precio();

    @ManyToOne
    @JoinColumn(name = "detalle_categoria_id")
    private DetalleCategoria detalleCategoria = new DetalleCategoria();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendedorProducto> vendedores = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Producto() {
        this.nombre = "";
        this.descripcion = "";
        this.precio = new Precio();
        this.detalleCategoria = new DetalleCategoria();
        this.vendedores = new ArrayList<>();
    }

    public Producto(String nombre, String descripcion, Precio precio, DetalleCategoria detalleCategoria) {
        this.nombre = (nombre != null) ? nombre : "";
        this.descripcion = (descripcion != null) ? descripcion : "";
        this.precio = (precio != null) ? precio : new Precio();
        this.detalleCategoria = (detalleCategoria != null) ? detalleCategoria : new DetalleCategoria();
        this.vendedores = new ArrayList<>();
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

    public DetalleCategoria getDetalleCategoria() {
        return detalleCategoria;
    }

    public void setDetalleCategoria(DetalleCategoria detalleCategoria) {
        this.detalleCategoria = (detalleCategoria != null) ? detalleCategoria : new DetalleCategoria();
    }

    public List<VendedorProducto> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<VendedorProducto> vendedores) {
        this.vendedores = (vendedores != null) ? vendedores : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Producto ejecutando lógica...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    private DetalleCategoria detalleCategoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public Categoria() {
        this.nombre = "";
        this.detalleCategoria = new DetalleCategoria();
    }

    public Categoria(String nombre, DetalleCategoria detalleCategoria, List<Producto> productos) {
        this.nombre = nombre;
        this.detalleCategoria = detalleCategoria;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DetalleCategoria getDetalleCategoria() {
        return detalleCategoria;
    }

    public void setDetalleCategoria(DetalleCategoria detalleCategoria) {
        this.detalleCategoria = detalleCategoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

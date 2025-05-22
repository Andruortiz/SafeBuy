package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private DetalleVendedor detalleVendedor = new DetalleVendedor(); // Nunca null

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>(); // Nunca null

    // ------------------------
    // Constructores
    // ------------------------

    public Vendedor() {
        this.detalleVendedor = new DetalleVendedor();
        this.productos = new ArrayList<>();
    }

    public Vendedor(DetalleVendedor detalleVendedor, List<Producto> productos) {
        this.detalleVendedor = (detalleVendedor != null) ? detalleVendedor : new DetalleVendedor();
        this.productos = (productos != null) ? productos : new ArrayList<>();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public DetalleVendedor getDetalleVendedor() {
        return detalleVendedor;
    }

    public void setDetalleVendedor(DetalleVendedor detalleVendedor) {
        this.detalleVendedor = (detalleVendedor != null) ? detalleVendedor : new DetalleVendedor();
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
        System.out.println("El vendedor está realizando una acción...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

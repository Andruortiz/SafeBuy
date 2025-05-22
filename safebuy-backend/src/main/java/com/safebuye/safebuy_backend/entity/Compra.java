package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalle = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "precio_id", referencedColumnName = "id")
    private Precio precioTotal = new Precio();

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Comprador comprador = new Comprador();

    // ------------------------
    // Constructores
    // ------------------------

    public Compra() {
        this.detalle = new ArrayList<>();
        this.precioTotal = new Precio();
        this.comprador = new Comprador();
    }

    public Compra(List<DetalleCompra> detalle, Precio precioTotal, Comprador comprador) {
        this.detalle = (detalle != null) ? detalle : new ArrayList<>();
        this.precioTotal = (precioTotal != null) ? precioTotal : new Precio();
        this.comprador = (comprador != null) ? comprador : new Comprador();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public List<DetalleCompra> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleCompra> detalle) {
        this.detalle = (detalle != null) ? detalle : new ArrayList<>();
    }

    public Precio getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Precio precioTotal) {
        this.precioTotal = (precioTotal != null) ? precioTotal : new Precio();
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = (comprador != null) ? comprador : new Comprador();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("La compra está ejecutando una acción...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

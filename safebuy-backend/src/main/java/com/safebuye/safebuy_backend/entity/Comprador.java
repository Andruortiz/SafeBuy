package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras = new ArrayList<>(); // Nunca null

    // ------------------------
    // Constructores
    // ------------------------

    public Comprador() {
        this.compras = new ArrayList<>();
    }

    public Comprador(List<Compra> compras) {
        this.compras = (compras != null) ? compras : new ArrayList<>();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = (compras != null) ? compras : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("El comprador está realizando una acción...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

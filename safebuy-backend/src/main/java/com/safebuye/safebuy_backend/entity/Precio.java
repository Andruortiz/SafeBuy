package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private BigDecimal valor = BigDecimal.ZERO;

    @OneToMany(mappedBy = "precio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePrecio> detalles = new ArrayList<>();

    // -------------------
    // Constructores
    // -------------------

    public Precio() {
        this.valor = BigDecimal.ZERO;
    }

    public Precio(BigDecimal valor) {
        this.valor = (valor != null) ? valor : BigDecimal.ZERO;
    }

    // -------------------
    // Getters y Setters
    // -------------------

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = (valor != null) ? valor : BigDecimal.ZERO;
    }

    public List<DetallePrecio> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePrecio> detalles) {
        this.detalles = (detalles != null) ? detalles : new ArrayList<>();
    }

    // -------------------
    // Métodos funcionales
    // -------------------

    public void hacerAlgo() {
        System.out.println("Operación sobre Precio realizada.");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) return "Texto inválido.";
        return "Precio Info: " + texto;
    }
}

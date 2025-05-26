package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Moneda moneda;

    public Precio() {
        this.valor = BigDecimal.ZERO;
        this.moneda = new Moneda();
    }

    public Precio(BigDecimal valor, Moneda moneda) {
        this.valor = valor;
        this.moneda = moneda;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}

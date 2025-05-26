package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetallePrecio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private boolean activo = true;

    // Constructor por defecto
    public DetallePrecio() {
        this.valor = BigDecimal.ZERO;
        this.descripcion = "";
        this.activo = true;
    }

    // Constructor parametrizado
    public DetallePrecio(BigDecimal valor, String descripcion, boolean activo) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Método funcional
    public boolean esMayorQue(BigDecimal referencia) {
        return this.valor.compareTo(referencia) > 0;
    }

    public static String formatearDescripcion(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "SIN DESCRIPCIÓN";
        }
        return texto.trim().toUpperCase();
    }
}

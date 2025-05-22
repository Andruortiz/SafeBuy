package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Pais {

    @Id
    private UUID id = UUID.randomUUID(); // Nunca null

    private String nombrePais = ""; // Valor vacío por defecto

    private String codigoISO = ""; // Valor vacío por defecto

    @OneToOne
    private Moneda moneda = new Moneda(); // Instancia por defecto, NO null

    private String activoTransaccion = "no confirmado"; // Valor inicial definido

    // ------------------------
    // Constructores
    // ------------------------

    public Pais() {
        // Constructor por defecto con todos los valores inicializados
    }

    public Pais(UUID id, String nombrePais, String codigoISO, Moneda moneda, String activoTransaccion) {
        this.id = id != null ? id : UUID.randomUUID();
        this.nombrePais = nombrePais != null ? nombrePais : "";
        this.codigoISO = codigoISO != null ? codigoISO : "";
        this.moneda = moneda != null ? moneda : new Moneda();
        this.activoTransaccion = activoTransaccion != null ? activoTransaccion : "no confirmado";
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id != null ? id : UUID.randomUUID();
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais != null ? nombrePais : "";
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO != null ? codigoISO : "";
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda != null ? moneda : new Moneda();
    }

    public String getActivoTransaccion() {
        return activoTransaccion;
    }

    public void setActivoTransaccion(String activoTransaccion) {
        this.activoTransaccion = activoTransaccion != null ? activoTransaccion : "no confirmado";
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public boolean esValidoParaTransaccion() {
        return "si".equalsIgnoreCase(this.activoTransaccion);
    }

    public static String combinarIdentificadorUnico(String texto) {
        texto = (texto == null || texto.isBlank()) ? "sin-nombre" : texto;
        return UUID.randomUUID() + "-" + texto;
    }

    public static void imprimirResumen() {
        System.out.println("Estado del país consultado.");
    }
}

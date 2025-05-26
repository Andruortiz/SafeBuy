package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    private String id;

    @Column(nullable = false)
    private String nombrePais;

    @Column(nullable = false)
    private String codigoISO;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "moneda_id", referencedColumnName = "id")
    private Moneda moneda;

    @Column(nullable = false)
    private String activoTransaccion;

    public Pais() {
        this.id = java.util.UUID.randomUUID().toString();
        this.nombrePais = "";
        this.codigoISO = "";
        this.activoTransaccion = "no confirmado";
        this.moneda = new Moneda();
    }

    public Pais(String id, String nombrePais, String codigoISO, Moneda moneda, String activoTransaccion) {
        this.id = id;
        this.nombrePais = nombrePais;
        this.codigoISO = codigoISO;
        this.moneda = moneda;
        this.activoTransaccion = activoTransaccion;
    }

    public String getId() {
        return id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String getActivoTransaccion() {
        return activoTransaccion;
    }

    public void setActivoTransaccion(String activoTransaccion) {
        this.activoTransaccion = activoTransaccion;
    }

    // Funcional
    public boolean esValidoParaTransaccion() {
        return "habilitado".equalsIgnoreCase(this.activoTransaccion);
    }

    public static String combinarIdentificadorUnico(String id, String nombrePais) {
        return (id + "-" + nombrePais).toUpperCase();
    }

    public static void imprimirResumen(Pais pais) {
        System.out.println("País: " + pais.getNombrePais() + " - Transacción: " + pais.getActivoTransaccion());
    }
}

package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;

    private String estado;

    private String respuesta;

    @ManyToOne(optional = false)
    private Compra compra;

    @ManyToOne(optional = false)
    private Vendedor vendedor;

    public Reclamo() {
        this.motivo = "";
        this.estado = "pendiente";
        this.respuesta = "";
    }

    public Reclamo(String motivo, String estado, String respuesta, Compra compra, Vendedor vendedor) {
        this.motivo = motivo;
        this.estado = estado;
        this.respuesta = respuesta;
        this.compra = compra;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}

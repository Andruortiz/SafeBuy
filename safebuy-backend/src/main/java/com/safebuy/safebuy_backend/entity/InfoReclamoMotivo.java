package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class InfoReclamoMotivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detalle;

    @ManyToOne(optional = false)
    private Reclamo reclamo;

    @ManyToOne(optional = false)
    private Motivo motivo;

    public InfoReclamoMotivo() {
        this.detalle = "";
    }

    public InfoReclamoMotivo(String detalle, Reclamo reclamo, Motivo motivo) {
        this.detalle = detalle;
        this.reclamo = reclamo;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }
}

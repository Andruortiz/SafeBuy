package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class HistorialReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaCambio;

    private String comentario;

    @ManyToOne(optional = false)
    private Reclamo reclamo;

    @ManyToOne(optional = false)
    private EstadoReclamo estado;

    public HistorialReclamo() {
        this.fechaCambio = LocalDate.now();
        this.comentario = "";
    }

    public HistorialReclamo(LocalDate fechaCambio, String comentario, Reclamo reclamo, EstadoReclamo estado) {
        this.fechaCambio = fechaCambio;
        this.comentario = comentario;
        this.reclamo = reclamo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }
}

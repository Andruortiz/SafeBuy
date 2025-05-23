package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistorialReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private LocalDate fechaCambio = LocalDate.now();

    private String comentario = "";

    @ManyToOne
    @JoinColumn(name = "reclamo_id")
    private Reclamo reclamo = new Reclamo();

    @ManyToOne
    @JoinColumn(name = "estado_reclamo_id")
    private EstadoReclamo estado = new EstadoReclamo();

    // ------------------------
    // Constructores
    // ------------------------

    public HistorialReclamo() {
        this.fechaCambio = LocalDate.now();
        this.comentario = "";
        this.reclamo = new Reclamo();
        this.estado = new EstadoReclamo();
    }

    public HistorialReclamo(LocalDate fechaCambio, String comentario, Reclamo reclamo, EstadoReclamo estado) {
        this.fechaCambio = (fechaCambio != null) ? fechaCambio : LocalDate.now();
        this.comentario = (comentario != null) ? comentario : "";
        this.reclamo = (reclamo != null) ? reclamo : new Reclamo();
        this.estado = (estado != null) ? estado : new EstadoReclamo();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = (fechaCambio != null) ? fechaCambio : LocalDate.now();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = (comentario != null) ? comentario : "";
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = (reclamo != null) ? reclamo : new Reclamo();
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = (estado != null) ? estado : new EstadoReclamo();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Ejecutando lógica del historial de reclamo...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

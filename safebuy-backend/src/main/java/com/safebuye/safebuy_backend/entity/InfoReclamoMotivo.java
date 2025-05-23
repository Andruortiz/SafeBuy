package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class InfoReclamoMotivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @ManyToOne
    @JoinColumn(name = "reclamo_id")
    private Reclamo reclamo = new Reclamo(); // Nunca null

    @ManyToOne
    @JoinColumn(name = "motivo_id")
    private Motivo motivo = new Motivo(); // Nunca null

    private String detalle = "";

    // ------------------------
    // Constructores
    // ------------------------

    public InfoReclamoMotivo() {
        this.reclamo = new Reclamo();
        this.motivo = new Motivo();
        this.detalle = "";
    }

    public InfoReclamoMotivo(Reclamo reclamo, Motivo motivo, String detalle) {
        this.reclamo = (reclamo != null) ? reclamo : new Reclamo();
        this.motivo = (motivo != null) ? motivo : new Motivo();
        this.detalle = (detalle != null) ? detalle : "";
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = (reclamo != null) ? reclamo : new Reclamo();
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = (motivo != null) ? motivo : new Motivo();
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = (detalle != null) ? detalle : "";
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("InfoReclamoMotivo en ejecución...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

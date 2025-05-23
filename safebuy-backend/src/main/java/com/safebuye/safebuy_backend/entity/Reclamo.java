package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String motivo = "";
    private String estadoTexto = ""; // Puede usarse como resumen textual si se desea

    private String respuesta = "";

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra = new Compra();

    @ManyToOne
    @JoinColumn(name = "estado_reclamo_id")
    private EstadoReclamo estadoReclamo = new EstadoReclamo(); // Relación directa ✔️

    // Relaciones inversas

    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialReclamo> historial = new ArrayList<>();

    @OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InfoReclamoMotivo> infoMotivos = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Reclamo() {
        this.motivo = "";
        this.estadoTexto = "";
        this.respuesta = "";
        this.compra = new Compra();
        this.estadoReclamo = new EstadoReclamo();
    }

    public Reclamo(String motivo, String estadoTexto, String respuesta, Compra compra, EstadoReclamo estadoReclamo) {
        this.motivo = (motivo != null) ? motivo : "";
        this.estadoTexto = (estadoTexto != null) ? estadoTexto : "";
        this.respuesta = (respuesta != null) ? respuesta : "";
        this.compra = (compra != null) ? compra : new Compra();
        this.estadoReclamo = (estadoReclamo != null) ? estadoReclamo : new EstadoReclamo();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = (motivo != null) ? motivo : "";
    }

    public String getEstadoTexto() {
        return estadoTexto;
    }

    public void setEstadoTexto(String estadoTexto) {
        this.estadoTexto = (estadoTexto != null) ? estadoTexto : "";
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = (respuesta != null) ? respuesta : "";
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = (compra != null) ? compra : new Compra();
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = (estadoReclamo != null) ? estadoReclamo : new EstadoReclamo();
    }

    public List<HistorialReclamo> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialReclamo> historial) {
        this.historial = (historial != null) ? historial : new ArrayList<>();
    }

    public List<InfoReclamoMotivo> getInfoMotivos() {
        return infoMotivos;
    }

    public void setInfoMotivos(List<InfoReclamoMotivo> infoMotivos) {
        this.infoMotivos = (infoMotivos != null) ? infoMotivos : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Reclamo en ejecución...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "El valor recibido es inválido.";
        }
        return "Impresión: " + texto;
    }
}

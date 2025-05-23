package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public final class Verificador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String tipoVerificacion = "";

    private boolean activo = true;

    @OneToOne(mappedBy = "verificador", cascade = CascadeType.ALL)
    private Pago pago = new Pago();

    // ------------------------
    // Constructores
    // ------------------------

    public Verificador() {
        this.tipoVerificacion = "";
        this.activo = true;
    }

    public Verificador(String tipoVerificacion, boolean activo) {
        this.tipoVerificacion = (tipoVerificacion != null) ? tipoVerificacion : "";
        this.activo = activo;
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getTipoVerificacion() {
        return tipoVerificacion;
    }

    public void setTipoVerificacion(String tipoVerificacion) {
        this.tipoVerificacion = (tipoVerificacion != null) ? tipoVerificacion : "";
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = (pago != null) ? pago : new Pago();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Verificador ejecutando lógica...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

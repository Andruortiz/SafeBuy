package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Verificador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoVerificacion;

    private boolean activo;

    public Verificador() {
        this.tipoVerificacion = "";
        this.activo = false;
    }

    public Verificador(String tipoVerificacion, boolean activo) {
        this.tipoVerificacion = tipoVerificacion;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getTipoVerificacion() {
        return tipoVerificacion;
    }

    public void setTipoVerificacion(String tipoVerificacion) {
        this.tipoVerificacion = tipoVerificacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

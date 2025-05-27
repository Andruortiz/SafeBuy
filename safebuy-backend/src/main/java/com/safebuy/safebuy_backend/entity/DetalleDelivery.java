package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class DetalleDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String direccion;

    private String empresaEnvio;

    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;



    public DetalleDelivery() {
        this.direccion = "";
        this.empresaEnvio = "";
        this.estado = "pendiente";
    }

    public DetalleDelivery(String direccion, String empresaEnvio, String estado, Compra compra) {
        this.direccion = direccion;
        this.empresaEnvio = empresaEnvio;
        this.estado = estado;
        this.compra = compra;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresaEnvio() {
        return empresaEnvio;
    }

    public void setEmpresaEnvio(String empresaEnvio) {
        this.empresaEnvio = empresaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}

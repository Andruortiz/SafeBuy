package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class DetalleDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String direccion = "";
    private String empresaEnvio = "";
    private String estado = "";

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra = new Compra();

    @OneToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery = new Delivery();

    // ------------------------
    // Constructores
    // ------------------------

    public DetalleDelivery() {
        this.direccion = "";
        this.empresaEnvio = "";
        this.estado = "";
    }

    public DetalleDelivery(String direccion, String empresaEnvio, String estado, Compra compra, Delivery delivery) {
        this.direccion = (direccion != null) ? direccion : "";
        this.empresaEnvio = (empresaEnvio != null) ? empresaEnvio : "";
        this.estado = (estado != null) ? estado : "";
        this.compra = (compra != null) ? compra : new Compra();
        this.delivery = (delivery != null) ? delivery : new Delivery();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = (direccion != null) ? direccion : "";
    }

    public String getEmpresaEnvio() {
        return empresaEnvio;
    }

    public void setEmpresaEnvio(String empresaEnvio) {
        this.empresaEnvio = (empresaEnvio != null) ? empresaEnvio : "";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = (estado != null) ? estado : "";
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = (compra != null) ? compra : new Compra();
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = (delivery != null) ? delivery : new Delivery();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("DetalleDelivery ejecutando lógica de entrega...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

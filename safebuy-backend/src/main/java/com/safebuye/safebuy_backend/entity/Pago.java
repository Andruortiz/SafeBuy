package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private double monto = 0.0;
    private String estado = "";

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra = new Compra();

    @OneToOne
    @JoinColumn(name = "verificador_id", nullable = false)
    private Verificador verificador = new Verificador();

    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<>();

    // ------------------------
    // Constructores
    // ------------------------

    public Pago() {
        this.estado = "";
    }

    public Pago(double monto, String estado, Compra compra, Verificador verificador) {
        this.monto = monto;
        this.estado = estado != null ? estado : "";
        this.compra = compra != null ? compra : new Compra();
        this.verificador = verificador != null ? verificador : new Verificador();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado != null ? estado : "";
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra != null ? compra : new Compra();
    }

    public Verificador getVerificador() {
        return verificador;
    }

    public void setVerificador(Verificador verificador) {
        this.verificador = verificador != null ? verificador : new Verificador();
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles != null ? detalles : new ArrayList<>();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void hacerAlgo() {
        System.out.println("Ejecutando lógica de Pago...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

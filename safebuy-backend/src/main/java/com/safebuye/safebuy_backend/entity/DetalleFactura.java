package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String descripcion = "";

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura = new Factura();

    @ManyToOne
    @JoinColumn(name = "pago_id", nullable = false)
    private Pago pago = new Pago();

    // ------------------------
    // Constructores
    // ------------------------

    public DetalleFactura() {
        this.descripcion = "";
    }

    public DetalleFactura(String descripcion, Factura factura, Pago pago) {
        this.descripcion = (descripcion != null) ? descripcion : "";
        this.factura = (factura != null) ? factura : new Factura();
        this.pago = (pago != null) ? pago : new Pago();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion : "";
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = (factura != null) ? factura : new Factura();
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
        System.out.println("DetalleFactura ejecutando lógica...");
    }

    public static String imprimirAlgo(String texto) {
        if (texto == null || texto.isBlank()) {
            return "Texto inválido.";
        }
        return "Impresión: " + texto;
    }
}

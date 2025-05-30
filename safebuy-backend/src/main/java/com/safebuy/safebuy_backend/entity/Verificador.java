package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Verificador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID keyDeliveryRecepcion;

    @Column(nullable = false, unique = true)
    private UUID keyDeliveryEntrega;

    @Column(nullable = false)
    private UUID keyVendedor;

    @Column(nullable = false)
    private UUID keyComprador;

    @Column(nullable = false)
    private String estado;  // Aprobada / No aprobada

    @Column(nullable = false, unique = true)
    private String combinacionUnica;

    @OneToOne
    @JoinColumn(name = "pago_id", nullable = false)
    private Pago pago;

    public Verificador() {
        this.estado = "No aprobada";
    }

    public Verificador(UUID keyDeliveryRecepcion, UUID keyDeliveryEntrega, UUID keyVendedor, UUID keyComprador, Pago pago) {
        this.keyDeliveryRecepcion = keyDeliveryRecepcion;
        this.keyDeliveryEntrega = keyDeliveryEntrega;
        this.keyVendedor = keyVendedor;
        this.keyComprador = keyComprador;
        this.pago = pago;
        this.combinacionUnica = generarCombinacionUnica();
        this.estado = "No aprobada";
    }

    private String generarCombinacionUnica() {
        return keyDeliveryEntrega + "+" + keyVendedor + "+" + keyComprador;
    }

    public void validarEstado() {
        if (!keyVendedor.equals("sin enviar") && !keyComprador.equals("sin recibir")) {
            this.estado = "aprobada";
        } else {
            this.estado = "No aprobada";
        }
    }

    // Getters y Setters omitidos por brevedad
}

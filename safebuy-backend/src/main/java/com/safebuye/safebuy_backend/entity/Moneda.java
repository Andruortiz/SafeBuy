package com.safebuye.safebuy_backend.entity;

import jakarta.persistence.*;

@Entity
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L; // Valor inicial seguro

    private String codigo = "";  // Nunca null

    private String nombre = "";  // Nunca null

    @OneToOne(mappedBy = "moneda")
    private Pais pais = new Pais(); // Relación gestionada por Pais

    // ------------------------
    // Constructores
    // ------------------------

    public Moneda() {
        this.codigo = "";
        this.nombre = "";
        this.pais = new Pais(); // Aseguramos instancia válida
    }

    public Moneda(String codigo, String nombre, Pais pais) {
        this.codigo = codigo != null ? codigo : "";
        this.nombre = nombre != null ? nombre : "";
        this.pais = pais != null ? pais : new Pais();
    }

    // ------------------------
    // Getters y Setters
    // ------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo != null ? codigo : "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre : "";
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais != null ? pais : new Pais();
    }

    // ------------------------
    // Métodos funcionales
    // ------------------------

    public void registrarMoneda(String codigo, Pais pais) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código de moneda no puede estar vacío.");
        }
        if (pais == null) {
            throw new IllegalArgumentException("El país no puede ser nulo.");
        }

        // Supuestamente aquí se valida contra base de datos
        // Esta lógica se mueve a un servicio normalmente

        this.codigo = codigo;
        this.pais = pais;
    }

    public boolean eliminarMoneda(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }

        // Aquí iría la lógica de validación si la moneda está en uso.
        return true; // Suponiendo que se puede eliminar
    }

    public boolean esValida() {
        if (this.codigo.isBlank() || this.nombre.isBlank()) {
            throw new RuntimeException("Los datos de la moneda son inválidos.");
        }
        return true;
    }

    public static String formatearCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código está vacío.");
        }
        return codigo.trim().toUpperCase();
    }
}

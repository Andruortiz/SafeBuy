package com.safebuy.safebuy_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private VendedorProducto detalleVendedor;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Vendedor() {
        this.detalleVendedor = new VendedorProducto();
        this.productos = new ArrayList<>();
    }

    public Vendedor(VendedorProducto detalleVendedor, List<Producto> productos) {
        this.detalleVendedor = detalleVendedor;
        this.productos = productos;
    }

    public UUID getId() {
        return id;
    }

    public VendedorProducto getDetalleVendedor() {
        return detalleVendedor;
    }

    public void setDetalleVendedor(VendedorProducto detalleVendedor) {
        this.detalleVendedor = detalleVendedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}

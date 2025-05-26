package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Vendedor;
import com.safebuy.safebuy_backend.service.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin(origins = "*")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    // 🔹 GET: Obtener todos los vendedores
    @GetMapping
    public ResponseEntity<List<Vendedor>> obtenerTodos() {
        return ResponseEntity.ok(vendedorService.obtenerTodos());
    }

    // 🔹 GET: Obtener vendedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> obtenerPorId(@PathVariable Long id) {
        return vendedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear nuevo vendedor
    @PostMapping
    public ResponseEntity<Vendedor> crear(@RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.crearVendedor(vendedor));
    }

    // 🔹 PUT: Actualizar vendedor
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> actualizar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.actualizarVendedor(id, vendedor));
    }

    // 🔹 DELETE: Eliminar vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vendedorService.eliminarVendedor(id);
        return ResponseEntity.noContent().build();
    }
}

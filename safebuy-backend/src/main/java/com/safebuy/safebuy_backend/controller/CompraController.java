package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Compra;
import com.safebuy.safebuy_backend.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    // 🔹 GET: Obtener todas las compras
    @GetMapping
    public ResponseEntity<List<Compra>> obtenerTodas() {
        return ResponseEntity.ok(compraService.obtenerTodas());
    }

    // 🔹 GET: Obtener compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerPorId(@PathVariable Long id) {
        return compraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear nueva compra
    @PostMapping
    public ResponseEntity<Compra> crear(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.crearCompra(compra));
    }

    // 🔹 PUT: Actualizar compra existente
    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizar(@PathVariable Long id, @RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.actualizarCompra(id, compra));
    }

    // 🔹 DELETE: Eliminar compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }
}

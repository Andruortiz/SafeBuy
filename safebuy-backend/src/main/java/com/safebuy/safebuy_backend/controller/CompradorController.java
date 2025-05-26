package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Comprador;
import com.safebuy.safebuy_backend.service.CompradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compradores")
@CrossOrigin(origins = "*")
public class CompradorController {

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    // 🔹 GET: Obtener todos los compradores
    @GetMapping
    public ResponseEntity<List<Comprador>> obtenerTodos() {
        return ResponseEntity.ok(compradorService.obtenerTodos());
    }

    // 🔹 GET: Obtener comprador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comprador> obtenerPorId(@PathVariable Long id) {
        return compradorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear nuevo comprador
    @PostMapping
    public ResponseEntity<Comprador> crear(@RequestBody Comprador comprador) {
        return ResponseEntity.ok(compradorService.crearComprador(comprador));
    }

    // 🔹 PUT: Actualizar comprador
    @PutMapping("/{id}")
    public ResponseEntity<Comprador> actualizar(@PathVariable Long id, @RequestBody Comprador comprador) {
        return ResponseEntity.ok(compradorService.actualizarComprador(id, comprador));
    }

    // 🔹 DELETE: Eliminar comprador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        compradorService.eliminarComprador(id);
        return ResponseEntity.noContent().build();
    }
}

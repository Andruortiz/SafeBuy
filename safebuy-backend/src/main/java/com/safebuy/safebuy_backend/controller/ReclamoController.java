package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Reclamo;
import com.safebuy.safebuy_backend.service.ReclamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamos")
@CrossOrigin(origins = "*")
public class ReclamoController {

    private final ReclamoService reclamoService;

    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    // 🔹 GET: Listar todos los reclamos
    @GetMapping
    public ResponseEntity<List<Reclamo>> obtenerTodos() {
        return ResponseEntity.ok(reclamoService.obtenerTodos());
    }

    // 🔹 GET: Obtener reclamo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> obtenerPorId(@PathVariable Long id) {
        return reclamoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear nuevo reclamo
    @PostMapping
    public ResponseEntity<Reclamo> crear(@RequestBody Reclamo reclamo) {
        return ResponseEntity.ok(reclamoService.crearReclamo(reclamo));
    }

    // 🔹 PUT: Actualizar un reclamo
    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizar(@PathVariable Long id, @RequestBody Reclamo reclamo) {
        return ResponseEntity.ok(reclamoService.actualizarReclamo(id, reclamo));
    }

    // 🔹 PUT: Responder reclamo
    @PutMapping("/{id}/respuesta")
    public ResponseEntity<Reclamo> responder(@PathVariable Long id, @RequestBody String respuesta) {
        return ResponseEntity.ok(reclamoService.responderReclamo(id, respuesta));
    }

    // 🔹 DELETE: Eliminar reclamo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reclamoService.eliminarReclamo(id);
        return ResponseEntity.noContent().build();
    }
}

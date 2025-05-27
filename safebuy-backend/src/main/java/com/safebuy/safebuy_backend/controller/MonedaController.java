package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Moneda;
import com.safebuy.safebuy_backend.service.MonedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monedas")
@CrossOrigin(origins = "*")
public class MonedaController {

    private final MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    // 🔹 GET: Obtener todas las monedas
    @GetMapping
    public ResponseEntity<List<Moneda>> obtenerTodas() {
        return ResponseEntity.ok(monedaService.obtenerTodas());
    }

    // 🔹 GET: Obtener moneda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Moneda> obtenerPorId(@PathVariable Long id) {
        return monedaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Registrar nueva moneda
    @PostMapping
    public ResponseEntity<Moneda> registrar(@RequestBody Moneda moneda) {
        return ResponseEntity.ok(monedaService.registrarMoneda(moneda));
    }

    // 🔹 PUT: Actualizar moneda
    @PutMapping("/{id}")
    public ResponseEntity<Moneda> actualizar(@PathVariable Long id, @RequestBody Moneda moneda) {
        return ResponseEntity.ok(monedaService.actualizarMoneda(id, moneda));
    }

    // 🔹 DELETE: Eliminar moneda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        monedaService.eliminarMoneda(id);
        return ResponseEntity.noContent().build();
    }
}

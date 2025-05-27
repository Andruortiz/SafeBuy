package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Factura;
import com.safebuy.safebuy_backend.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // 🔹 GET: Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodas() {
        return ResponseEntity.ok(facturaService.obtenerFacturas());
    }

    // 🔹 GET: Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Long id) {
        return facturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear una nueva factura
    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    // 🔹 PUT: Actualizar una factura existente
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.actualizarFactura(id, factura));
    }

    // 🔹 DELETE: Eliminar factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}

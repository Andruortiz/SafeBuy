package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Pais;
import com.safebuy.safebuy_backend.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    // 🔹 GET: Obtener todos los países
    @GetMapping
    public ResponseEntity<List<Pais>> obtenerTodos() {
        return ResponseEntity.ok(paisService.obtenerTodos());
    }

    // 🔹 GET: Obtener un país por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pais> obtenerPorId(@PathVariable String id) {
        return paisService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST: Crear país
    @PostMapping
    public ResponseEntity<Pais> crear(@RequestBody Pais pais) {
        return ResponseEntity.ok(paisService.crearPais(pais));
    }

    // 🔹 PUT: Actualizar país
    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizar(@PathVariable String id, @RequestBody Pais pais) {
        return ResponseEntity.ok(paisService.actualizarPais(id, pais));
    }

    // 🔹 DELETE: Eliminar país
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        paisService.eliminarPais(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 GET: Verificar si el país está habilitado para transacción
    @GetMapping("/{id}/habilitado")
    public ResponseEntity<Boolean> estaHabilitado(@PathVariable String id) {
        return ResponseEntity.ok(paisService.estaHabilitadoParaTransaccion(id));
    }
}

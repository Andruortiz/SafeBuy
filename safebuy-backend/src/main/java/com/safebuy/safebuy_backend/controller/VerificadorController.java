package com.safebuy.safebuy_backend.controller;

import com.safebuy.safebuy_backend.entity.Verificador;
import com.safebuy.safebuy_backend.service.VerificadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/verificadores")
public class VerificadorController {

    private final VerificadorService verificadorService;

    public VerificadorController(VerificadorService verificadorService) {
        this.verificadorService = verificadorService;
    }

    @PostMapping
    public ResponseEntity<Verificador> crear(@RequestBody Verificador verificador) {
        return ResponseEntity.ok(verificadorService.crearVerificacion(verificador));
    }

    @PutMapping("/{id}/actualizar-estado")
    public ResponseEntity<Verificador> actualizarEstado(@PathVariable UUID id) {
        return ResponseEntity.ok(verificadorService.actualizarEstado(id));
    }

    @GetMapping
    public ResponseEntity<List<Verificador>> obtenerTodos() {
        return ResponseEntity.ok(verificadorService.obtenerTodas());
    }
}

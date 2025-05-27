package com.safebuy.safebuy_backend.dto;

import java.util.UUID;

public class FacturaDTO {
    private UUID id;
    private String fechaEmision;
    private Long compraId;
    private Long metodoPagoId;
    private Long verificadorId;
}

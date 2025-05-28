package com.safebuy.safebuy_backend.dto;

import java.util.List;
import java.util.UUID;

public class VendedorDTO {
    private UUID id;
    private Long detalleVendedorId;
    private List<Long> productosId;
}

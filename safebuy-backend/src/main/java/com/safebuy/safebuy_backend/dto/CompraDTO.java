package com.safebuy.safebuy_backend.dto;

import java.util.List;
import java.util.UUID;

public class CompraDTO {
    private UUID id;
    private List<Long> detallesCompraId;
    private Long precioTotalId;
    private Long compradorId;
}

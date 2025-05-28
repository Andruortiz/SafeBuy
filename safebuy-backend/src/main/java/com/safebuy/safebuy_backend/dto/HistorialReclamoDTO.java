package com.safebuy.safebuy_backend.dto;

import java.util.Date;
import java.util.UUID;

public class HistorialReclamoDTO {
    private UUID id;
    private Date fechaCambio;
    private String comentario;
    private Long reclamoId;
    private Long estadoReclamoId;
}

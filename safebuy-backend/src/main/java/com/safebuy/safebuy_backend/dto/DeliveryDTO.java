package com.safebuy.safebuy_backend.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DeliveryDTO {
    private UUID id;
    private Date fechaEnvio;
    private List<Long> detallesId;
}

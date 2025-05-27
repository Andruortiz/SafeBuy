package com.safebuy.safebuy_backend.dto;

import java.util.Date;
import java.util.List;

public class DeliveryDTO {
    private Long id;
    private Date fechaEnvio;
    private List<Long> detallesId;
}

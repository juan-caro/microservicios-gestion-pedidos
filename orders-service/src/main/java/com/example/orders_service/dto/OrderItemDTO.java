package com.example.orders_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItemDTO {

    @NotNull(message = "El ID del producto es obligatorio")
    private UUID productId;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "Debe haber al menos un producto")
    private Integer quantity;

    @NotNull(message = "El precio unitario es obligatorio")
    @Min(value = 0, message = "El precio unitario debe ser mayor o igual a 0")
    private BigDecimal price;
}


package com.example.orders_service.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
public class OrderDTO {

    @NotNull(message = "El ID del cliente es obligatorio")
    private UUID customerId;

    @NotNull(message = "El total del pedido es obligatorio")
    @Min(value = 0, message = "El total debe ser mayor o igual a 0")
    private BigDecimal totalAmount;

    @NotNull(message = "Los ítems del pedido son obligatorios")
    private List<OrderItemDTO> items;
}



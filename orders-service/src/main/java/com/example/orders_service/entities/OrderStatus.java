package com.example.orders_service.entities;

public enum OrderStatus {
    PENDING,      // Pedido pendiente de pago o confirmación
    PROCESSING,   // Pedido en proceso
    SHIPPED,      // Pedido enviado
    DELIVERED,    // Pedido entregado
    CANCELED      // Pedido cancelado
}

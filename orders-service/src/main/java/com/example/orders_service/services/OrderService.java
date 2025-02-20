package com.example.orders_service.services;

import com.example.orders_service.dto.OrderDTO;
import com.example.orders_service.entities.Order;
import com.example.orders_service.entities.OrderItem;
import com.example.orders_service.entities.OrderStatus;
import com.example.orders_service.exception.OrderNotFoundException;
import com.example.orders_service.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = orderDTO.getItems().stream().map(dto -> {
            OrderItem item = new OrderItem();
            item.setProductId(dto.getProductId());
            item.setQuantity(dto.getQuantity());
            item.setPrice(dto.getPrice());
            item.setOrder(order); // Relación con Order
            return item;
        }).toList();

        order.setItems(orderItems);

        return orderRepository.save(order);
    }



    public Order getOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Pedido con ID " + id + " no encontrado"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
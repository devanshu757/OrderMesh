package com.ordermesh.order.controller;

import com.ordermesh.order.model.Order;
import com.ordermesh.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(
            @RequestParam String productId,
            @RequestParam int quantity) {
        return service.createOrder(productId, quantity);
    }
}

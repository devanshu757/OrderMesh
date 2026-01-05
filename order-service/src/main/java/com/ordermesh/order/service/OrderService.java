package com.ordermesh.order.service;

import com.ordermesh.order.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Order createOrder(String productId, int quantity) {

        Boolean reserved = restTemplate.postForObject(
                "http://localhost:8081/inventory/reserve" +
                        "?productId=" + productId +
                        "&quantity=" + quantity,
                null,
                Boolean.class
        );

        if (Boolean.FALSE.equals(reserved)) {
            throw new IllegalStateException("Inventory not available");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                productId,
                quantity
        );
        order.confirm();
        return order;
    }
}

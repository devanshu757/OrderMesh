package com.ordermesh.order.model;

public class Order {

    private final String orderId;
    private final String productId;
    private final int quantity;
    private String status;

    public Order(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = "CREATED";
    }

    public void confirm() {
        this.status = "CONFIRMED";
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}

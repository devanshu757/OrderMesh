package com.ordermesh.inventory.model;

public class InventoryItem {
    private final String productId;
    private int quantity;

    public InventoryItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public synchronized boolean reserve(int amount) {
        if (quantity < amount) {
            return false;
        }
        quantity -= amount;
        return true;
    }
}

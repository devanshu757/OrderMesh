package com.inventory.model;

public class InventoryItem {

    private String productId;
    private int quantity;

    public InventoryItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceStock(int amount) {
        if (quantity < amount) {
            throw new IllegalStateException("Insufficient stock");
        }
        quantity -= amount;
    }
}

package com.ordermesh.inventory.service;

import com.ordermesh.inventory.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InventoryService {

    private final ConcurrentHashMap<String, InventoryItem> store =
            new ConcurrentHashMap<>();

    public InventoryService() {
        store.put("P100", new InventoryItem("P100", 10));
        store.put("P200", new InventoryItem("P200", 5));
    }

    public boolean reserveStock(String productId, int quantity) {
        InventoryItem item = store.get(productId);
        return item != null && item.reserve(quantity);
    }
}

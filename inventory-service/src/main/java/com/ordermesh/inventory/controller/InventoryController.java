package com.ordermesh.inventory.controller;

import com.ordermesh.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping("/reserve")
    public boolean reserve(
            @RequestParam String productId,
            @RequestParam int quantity) {
        return service.reserveStock(productId, quantity);
    }
}

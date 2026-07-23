package com.hermesafe.domain;

public class OrderService {

    private final InventoryRepository inventoryRepository;

    public OrderService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean processOrder(String productId, int quantity) {
        int available = inventoryRepository.getStock(productId);
        if (available < quantity) {
            return false; // not enough stock
        }
        inventoryRepository.removeStock(productId, quantity);
        return true;
    }
}
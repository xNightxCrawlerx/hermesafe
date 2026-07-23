package com.hermesafe.domain;

public interface InventoryRepository {
    int getStock(String productId);
    void removeStock(String productId, int quantity);
}
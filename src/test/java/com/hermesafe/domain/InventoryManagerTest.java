package com.hermesafe.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    @Test
    void shouldInitializeWithValidStock() {
        // Arrange & Act
        InventoryManager manager = new InventoryManager(10);

        // Assert
        assertEquals(10, manager.getStock());
    }

    @Test
    void shouldThrowExceptionForNegativeInitialStock() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new InventoryManager(-5);
        });
    }

    @Test
    void shouldAddStockCorrectly() {
        // Arrange
        InventoryManager manager = new InventoryManager(10);

        // Act
        manager.addStock(5);

        // Assert
        assertEquals(15, manager.getStock());
    }

    @Test
    void shouldThrowExceptionForInvalidAddStock() {
        // Arrange
        InventoryManager manager = new InventoryManager(10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStock(0);
        });
    }

    @Test
    void shouldRemoveStockCorrectly() {
        // Arrange
        InventoryManager manager = new InventoryManager(10);

        // Act
        manager.removeStock(4);

        // Assert
        assertEquals(6, manager.getStock());
    }

    @Test
    void shouldThrowExceptionForZeroRemoveStock() {
        // Arrange
        InventoryManager manager = new InventoryManager(10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStock(0);
        });
    }

    @Test
    void shouldThrowExceptionForNegativeRemoveStock() {
        // Arrange
        InventoryManager manager = new InventoryManager(10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStock(-3);
        });
    }

    @Test
    void shouldThrowExceptionWhenRemovingMoreThanAvailable() {
        // Arrange
        InventoryManager manager = new InventoryManager(5);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            manager.removeStock(10);
        });
    }
}
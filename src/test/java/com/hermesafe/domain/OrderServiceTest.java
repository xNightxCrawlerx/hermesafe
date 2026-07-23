
package com.hermesafe.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void shouldProcessOrderWhenEnoughStock() {
        // Arrange
        InventoryRepository repo = mock(InventoryRepository.class);
        when(repo.getStock("P001")).thenReturn(10);

        OrderService service = new OrderService(repo);

        // Act
        boolean result = service.processOrder("P001", 5);

        // Assert
        assertTrue(result);
        verify(repo).removeStock("P001", 5);
    }

    @Test
    void shouldNotProcessOrderWhenInsufficientStock() {
        // Arrange
        InventoryRepository repo = mock(InventoryRepository.class);
        when(repo.getStock("P001")).thenReturn(3);

        OrderService service = new OrderService(repo);

        // Act
        boolean result = service.processOrder("P001", 5);

        // Assert
        assertFalse(result);
        verify(repo, never()).removeStock(anyString(), anyInt());
    }
}

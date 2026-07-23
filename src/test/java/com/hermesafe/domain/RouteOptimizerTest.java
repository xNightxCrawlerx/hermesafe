package com.hermesafe.domain;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RouteOptimizerTest {

    @Test
    void shouldThrowExceptionForNullWarehouseDistances() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new RouteOptimizer(null);
        });
    }

    @Test
    void shouldThrowExceptionForEmptyWarehouseDistances() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new RouteOptimizer(Collections.emptyMap());
        });
    }

    @Test
    void shouldReturnTrueIfCityIsCovered() {
        // Arrange
        Map<String, Integer> distances = Map.of("Santiago", 10, "Valparaiso", 50);
        RouteOptimizer optimizer = new RouteOptimizer(distances);

        // Act
        boolean result = optimizer.isCityCovered("Santiago");

        // Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfCityIsNotCovered() {
        // Arrange
        Map<String, Integer> distances = Map.of("Santiago", 10);
        RouteOptimizer optimizer = new RouteOptimizer(distances);

        // Act
        boolean result = optimizer.isCityCovered("Valparaiso");

        // Assert
        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionForNullCity() {
        // Arrange
        Map<String, Integer> distances = Map.of("Santiago", 10);
        RouteOptimizer optimizer = new RouteOptimizer(distances);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            optimizer.isCityCovered(null);
        });
    }

    @Test
    void shouldThrowExceptionWhenCityIsBlank() {
        Map<String, Integer> distances = Map.of("Santiago", 10);
        RouteOptimizer optimizer = new RouteOptimizer(distances);

        assertThrows(IllegalArgumentException.class, () -> optimizer.isCityCovered(" "));
    }

    @Test
    void shouldReturnWarehousesSortedByDistance() {
        // Arrange
        Map<String, Integer> distances = Map.of("Santiago", 10, "Valparaiso", 50, "Concepcion", 30);
        RouteOptimizer optimizer = new RouteOptimizer(distances);

        // Act
        List<String> result = optimizer.getClosestWarehouses();

        // Assert
        assertEquals(Arrays.asList("Santiago", "Concepcion", "Valparaiso"), result);
    }
}
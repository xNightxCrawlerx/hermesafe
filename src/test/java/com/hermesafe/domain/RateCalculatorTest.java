package com.hermesafe.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RateCalculatorTest {

    @Test
    void shouldThrowExceptionForNegativeWeight() {
        // Arrange
        RateCalculator calculator = new RateCalculator();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(-1, 50, false);
        });
    }

    @Test
    void shouldApplyBaseRateForLightPackage() {
        // Arrange
        RateCalculator calculator = new RateCalculator();

        // Act
        double result = calculator.calculate(1.5, 50, false);

        // Assert
        assertEquals(100.0, result);
    }

    @Test
    void shouldApplyWeightSurcharge() {
        // Arrange
        RateCalculator calculator = new RateCalculator();

        // Act
        double result = calculator.calculate(3.0, 50, false);

        // Assert
        assertEquals(120.0, result);
    }

    @Test
    void shouldApplyRuralSurcharge() {
        // Arrange
        RateCalculator calculator = new RateCalculator();

        // Act
        double result = calculator.calculate(1.5, 50, true);

        // Assert
        assertEquals(115.0, result, 0.0001);
    }
}
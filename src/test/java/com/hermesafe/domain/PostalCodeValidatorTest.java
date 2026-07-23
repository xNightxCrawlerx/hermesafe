package com.hermesafe.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PostalCodeValidatorTest {

    @Test
    void shouldThrowExceptionForNullPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValid(null);
        });
    }

    @Test
    void shouldThrowExceptionForBlankPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValid("   ");
        });
    }

    @Test
    void shouldReturnTrueForValidPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act
        boolean result = validator.isValid("12345");

        // Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForValidAlphanumericPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act
        boolean result = validator.isValid("A1B2C3");

        // Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInvalidPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act
        boolean result = validator.isValid("12@#");

        // Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForTooLongPostalCode() {
        // Arrange
        PostalCodeValidator validator = new PostalCodeValidator();

        // Act
        boolean result = validator.isValid("ABCDEFG");

        // Assert
        assertFalse(result);
    }
}
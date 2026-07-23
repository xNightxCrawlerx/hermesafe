package com.hermesafe.domain;

import java.util.regex.Pattern;

public class PostalCodeValidator {

    // Example pattern: 5 digits (US style) or alphanumeric with 6 characters
    private static final Pattern VALID_PATTERN = Pattern.compile("^[A-Za-z0-9]{5,6}$");

    public boolean isValid(String postalCode) {
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be null or blank");
        }
        return VALID_PATTERN.matcher(postalCode).matches();
    }
}
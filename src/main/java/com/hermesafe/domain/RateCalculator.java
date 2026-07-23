package com.hermesafe.domain;

public class RateCalculator {

    private static final double BASE_RATE = 100.0;

    public double calculate(double weight, int distance, boolean isRural) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive :)");
        }

        double price = BASE_RATE;

        if (weight > 2) {
            price += 20; // surcharge for heavy packages
        }

        if (isRural) {
            price *= 1.15; // rural surcharge
        }

        return price;
    }
}
package com.nisum.calculator.legacy;




public class PriceCalculator {
    public double getBasePrice() {
        return 100.0;
    }

    private double calculateTax() {
        return 20.0;
    }

    public double calculateFinalPrice() {
        return getBasePrice() + calculateTax();
    }
}



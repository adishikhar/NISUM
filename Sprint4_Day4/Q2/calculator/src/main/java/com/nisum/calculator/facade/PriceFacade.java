package com.nisum.calculator.facade;




import com.nisum.calculator.legacy.PriceCalculator;

public class PriceFacade extends PriceCalculator {


    public double doCalculation() {
        return super.calculateFinalPrice();
    }

    @Override
    public double calculateFinalPrice() {
        try {
            return doCalculation(); // ✅ spy on this
        } catch (ArithmeticException e) {
            return 99.0; // fallback
        }
    }

    public double getPrice() {
        return calculateFinalPrice();
    }
}



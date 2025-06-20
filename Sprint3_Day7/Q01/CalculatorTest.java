package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAddition() {
        int result = calc.add(10, 5);
        assertEquals(15, result);
        assertNotEquals(20, result);
    }

    @Test
    public void testSubtraction() {
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        int result = calc.multiply(3, 7);
        assertEquals(21, result);
    }

    @Test
    public void testDivision() {
        int result = calc.divide(20, 4);
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
}

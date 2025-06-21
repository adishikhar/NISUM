package com.nisum;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSub() {
        assertEquals(1, calc.subtract(4, 3));
    }

    @Test
    void testMul() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void testDiv() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}


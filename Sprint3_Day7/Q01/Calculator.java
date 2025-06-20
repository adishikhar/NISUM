package Sprint3_Day7.Q01;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        // This will throw ArithmeticException if b is 0 (which is what we want to test later)
        return a / b;
    }
}

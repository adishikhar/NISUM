package Sprint1_Day1;

class Calculator {
    static void add(int a, int b) {
        System.out.println("Sum of 2 numbers: " + (a + b));
    }

    static void add(int a, int b, int c) {
        System.out.println("Sum of 3 numbers: " + (a + b + c));
    }
}

public class Q10 {
    public static void main(String[] args) {
        Calculator.add(5, 10);
        Calculator.add(1, 2, 3);
    }
}


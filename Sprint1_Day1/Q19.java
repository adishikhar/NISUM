package Sprint1_Day1;

class overloading {
    void sum(int a, int b) {
        System.out.println("Sum of 2 numbers: " + (a + b));
    }

    void sum(int a, int b, int c) {
        System.out.println("Sum of 3 numbers: " + (a + b + c));
    }

    void sum(double a, double b) {
        System.out.println("Sum of 2 doubles: " + (a + b));
    }
}

public class Q19 {
    public static void main(String[] args) {
        overloading m = new overloading();
        m.sum(2, 3);
        m.sum(1, 2, 3);
        m.sum(2.5, 3.5);
    }
}


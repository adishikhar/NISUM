package Q1;

import java.util.Scanner;

public class Q1 {

    static double  divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("divisible by zero is not possible");
        }
        return a / b;
    }

    public static void main(String[] args) {
        int a, b;
        String ch;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter two number: ");
            a = sc.nextInt();
            b = sc.nextInt();
            try {
                double result = divide(a, b);
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("Error: "+ e.getMessage());
            }

            System.out.println("Want to give more input , Y/N ? ");
            ch = sc.next().toUpperCase();

        } while (ch.equalsIgnoreCase("Y"));
sc.close();
    }
}
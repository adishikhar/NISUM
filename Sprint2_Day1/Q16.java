@FunctionalInterface
interface interfaceA {
    int calculate(int a, int b);
}


public class Q16 {
    public static void main(String[] args) {
        interfaceA add = (a, b) -> a + b;

        interfaceA sub = (a, b) -> a - b;

        interfaceA mul = (a, b) -> a * b;

        int x = 6, y = 2;
        System.out.println("Add: " + add.calculate(x, y));         
        System.out.println("Subtract: " + sub.calculate(x, y)); 
        System.out.println("Multiply: " + mul.calculate(x, y)); 
    }
}

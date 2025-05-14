import java.util.*;

public class Q11 {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int num1 = 10;
        int num2 = 20;
        int num3 = 30;

        stack.push(num1);
        stack.push(num2);
        stack.push(num3);

        int topElement = stack.peek();
        System.out.println("Top element : " + topElement);

        int removed = stack.pop();
        System.out.println("Popped: " + removed);

        int newTop = stack.peek();
        System.out.println("New Top: " + newTop);
    }
}

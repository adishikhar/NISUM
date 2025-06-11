package Q4;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(utility.wrap());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

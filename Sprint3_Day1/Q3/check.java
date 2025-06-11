package Q3;



import java.util.Scanner;

public class check {

    static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid Age: " + age);
        }
        System.out.println(age);
    }

    public static void main(String[] args) {
        // Try-with-resources to ensure Scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of age inputs: ");
            int count = scanner.nextInt();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter age : ");
                try {
                    int age = scanner.nextInt();
                    validateAge(age);
                } catch (InvalidAgeException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected Error: " + e.getMessage());
                    scanner.nextLine();
                }
            }
        }
    }
}


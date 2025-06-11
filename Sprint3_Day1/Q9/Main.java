package Q9;

public class Main {
    public static void main(String[] args) {
        User user = new User("", -5, "invalid-email");

        try {
            new Validator<>(user)
                .rule(u -> !u.name().isBlank(), "Name must not be blank")
                .rule(u -> u.age() > 0, "Age must be positive")
                .rule(u -> u.email().contains("@"), "Email must be valid")
                .validate();

            System.out.println("Validation passed!");
        } catch (ValidationException e) {
            System.out.println("Validation failed:");
            e.getErrors().forEach(System.out::println);
        }
    }
}


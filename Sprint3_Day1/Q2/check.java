package Q2;



public class check {

    static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid Age");
        }
        System.out.println("age: " + age);
    }

    public static void main(String[] args) {
        int[] input = { 2, 18, 0, -1, 13 };

        for (int age : input) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
    }
}

package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String firstName;
    String lastName;
    String gender;

    Employee(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}

public class Q11 {
    public static void main(String[] args) {
        List<Employee> empl = Arrays.asList(
            new Employee("Aditya", "Shikhar", "Male"),
            new Employee("Richa", "Mishra", "Female"),
            new Employee("Kritika", "Modi", "Female"),
            new Employee("Anusha", "Kumari", "Female"),
            new Employee("Virat", "Kholi", "Male")
        );

        Map<String, Long> Gcount = empl.stream()
            .collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));

        Gcount.forEach((gender, count) -> 
            System.out.println(gender + ": " + count));
    }
}

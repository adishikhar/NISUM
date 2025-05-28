package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String firstName;
    String lastName;

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

public class Q08 {
    public static void main(String[] args) {
        List<Employee> empl = Arrays.asList(
            new Employee("Aditya", "Shikhar"),
            new Employee("Richa", "Mishra"),
            new Employee("Anusha", "Kumari"),
            new Employee("Kritika ", "Modi")
        );

        String name = empl.stream()
            .map(e -> e.firstName + e.lastName)    
            .collect(Collectors.joining("|"));

        System.out.println(name);
    }
}


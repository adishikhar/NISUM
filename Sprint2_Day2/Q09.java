package Sprint2_Day2;

import java.util.*;


class Employee {
    String firstName;
    String lastName;
    String department;

    Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
}

public class Q09 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "Shikhar", "HR"),
            new Employee("Mishra", "Richa", "Engineering"),
            new Employee("modi", "modi", "HR"),
            new Employee("Shikhar", "Dhawan", "Marketing"),
            new Employee("Raiyan", "MD", "Engineering"),
            new Employee("Kritika", "Modi", "Sales"),
            new Employee("Anusha", "Kumari", "HR"),
            new Employee("Rohit", "Sharma", "Marketing"),
            new Employee("Virat", "Kholi", "Finance"),
            new Employee("Jack", "Rohait", "Engineering")
        );

        Optional<Employee> eighthEmployee = employees.stream()
            .skip(7)
            .findFirst();

        eighthEmployee.ifPresent(e -> {
            String fullName = e.firstName + " " + e.lastName;
            System.out.println("8th Employee: " + fullName + ", Department: " + e.department);
        });
    }
}


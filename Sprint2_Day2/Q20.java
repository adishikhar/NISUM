package Sprint2_Day2;

import java.util.*;

class Employee {
    private String name;
    private String department;
    private String email;

    public Employee(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
}

public class Q20 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "HR", "aditya@gmail.com"),
            new Employee("Shikhar", "IT", "Shikhar@gmail.com"),
            new Employee("Richa", "Finance", null),
            new Employee(null, "HR", "Kritika@gmail.com")
        );

       
        boolean anyFromHR = employees.stream()
                                    .anyMatch(e -> "HR".equalsIgnoreCase(e.getDepartment()));
        System.out.println("Any employee from HR? " + anyFromHR);

       
        boolean allHaveEmail = employees.stream()
                                       .allMatch(e -> e.getEmail() != null && !e.getEmail().isEmpty());
        System.out.println("All employees have email? " + allHaveEmail);

        boolean noneHaveNullName = employees.stream()
                                           .noneMatch(e -> e.getName() == null);
        System.out.println("No employee has null name? " + noneHaveNullName);
    }
}


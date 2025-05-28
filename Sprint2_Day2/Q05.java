package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String firstName;
    String lastName;
    String department;

    Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + department + ")";
    }
}

public class Q05 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "Shikhar", "HR"),
            new Employee("Richa", "Mishra", "Engineering"),
            new Employee("Kritika", "Modi", "HR"),
            new Employee("Rahul", "Kumar", "Marketing")
        );

        String dept = "HR";

        List<Employee> name = employees.stream()
            .filter(e -> !e.department.equalsIgnoreCase(dept))
            .collect(Collectors.toList());

        name.forEach(System.out::println);
    }
}

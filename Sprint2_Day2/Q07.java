package Sprint2_Day2;

import java.util.*;

class Employee {
    int empId;
    String firstName;
    String lastName;

    Employee(int empId, String firstName, String lastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return empId + ": " + firstName + " " + lastName;
    }
}

public class Q07 {
    public static void main(String[] args) {
        List<Employee> empl = Arrays.asList(
            new Employee(7, "Aditya", "Shikhar"),
            new Employee(3,  "Richa", "Mishra"),
            new Employee(10, "Anusha", "Kumari"),
            new Employee(1, "Kritika ", "Modi")
        );

        empl.stream()
            .max(Comparator.comparingInt(e -> e.empId))
            .ifPresent(e -> System.out.println("Employee with highest empId: " + e));
    }
}


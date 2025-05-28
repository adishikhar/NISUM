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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Q06 {
    public static void main(String[] args) {
        List<Employee> emp = Arrays.asList(
            new Employee("Aditya", "Shikhar"),
            new Employee("Richa", "Mishra"),
            new Employee("Anusha", "Kumari"),
            new Employee("Kritika ", "Modi")
        );

        List<Employee> sort = emp.stream()
            .sorted(Comparator.comparing(e -> e.firstName))
            .collect(Collectors.toList());

        sort.forEach(System.out::println);
    }
}

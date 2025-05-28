package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }
}

public class Q13 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", 200),
            new Employee("Shikhar", 500),
            new Employee("Richa", 300),
            new Employee("Mishra", 700)
        );

        List<Employee> sort = employees.stream()
            .sorted(Comparator.comparingDouble(e -> e.salary))
            .collect(Collectors.toList());

        sort.forEach(System.out::println);
    }
}


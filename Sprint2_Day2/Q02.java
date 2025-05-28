package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

public class Q02 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "HR"),
            new Employee("Shikhar", "Engineering"),
            new Employee("Richa", "HR"),
            new Employee("Mishra", "Engineering"),
            new Employee("Kritika", "Marketing")
        );

        Map<String, Long> map = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,     
                Collectors.counting() 
            ));

        System.out.println(map);
    }
}

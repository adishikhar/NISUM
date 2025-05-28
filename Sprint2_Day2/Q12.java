package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

class Employee {
    String firstName;
    String gender;

    Employee(String firstName, String gender) {
        this.firstName = firstName;
        this.gender = gender;
    }
}

public class Q12 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "Male"),
            new Employee("Richa", "Female"),
            new Employee("Kritika", "Female"),
            new Employee("Virat", "Male")
        );

        Map<String, String> Gnames = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.gender.toUpperCase(),                                     
                Collectors.mapping(e -> e.firstName, Collectors.joining("-"))  
            ));

        String result = Gnames.entrySet().stream()
            .map(entry -> entry.getKey() + ": [" + entry.getValue() + "]")
            .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}

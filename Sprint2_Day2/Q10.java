package Sprint2_Day2;

import java.util.*;
import java.util.stream.*;

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

public class Q10 {
    public static void main(String[] args) {
        List<Employee> Empl = Arrays.asList(
           new Employee(1, "Aditya", "Shikhar"),
            new Employee(2,  "Richa", "Mishra"),
            new Employee(3, "Anusha", "Kumari"),
            new Employee(4, "Kritika ", "Modi")
        );

        List<Integer> Ids = Arrays.asList(2, 4);

        Set<Integer> idSet = new HashSet<>(Ids);

        List<Employee> matched = Empl.stream()
            .filter(e -> idSet.contains(e.empId))
            .collect(Collectors.toList());

        matched.forEach(System.out::println);
    }
}


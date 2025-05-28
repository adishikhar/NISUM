package Sprint2_Day2;

import java.util.*;

class Employee {
    private String name;
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public String toString() { return "Employee{name='" + name + "'}"; }
}

public class Q19 {
    public static void main(String[] args) {
        List<Employee> empl = Arrays.asList(
            new Employee("Aditya"),
            new Employee("Shikhar"),
            new Employee("Richa")
        );

        
        Optional<Employee> anyEmployee = empl.stream().findAny();
        anyEmployee.ifPresent(e -> System.out.println("Any employee: " + e));

        Optional<Employee> firstEmployee = empl.stream().findFirst();
        firstEmployee.ifPresent(e -> System.out.println("First employee: " + e));
    }
}


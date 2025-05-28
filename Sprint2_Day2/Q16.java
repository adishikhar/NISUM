package Sprint2_Day2;

import java.util.*;

class Employee {
    private String name;
    private double salary;
    private Optional<String> department = Optional.empty();

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = Optional.ofNullable(department);
    }

    public Optional<String> Department() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        this.salary += amount;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println(name + ": " + salary + " - Dept: " + department.orElse("N/A"));
    }
}

public class Q16 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", 200, "IT"),
            new Employee("Shikhar", 300, "HR"),
            new Employee("Richa", 700, "IT"),
            new Employee("Mishra", 500, null)
        );

        
        employees.forEach(emp -> {
            emp.Department().ifPresent(dept -> {
                if (dept.equalsIgnoreCase("IT")) {
                    double increment = emp.getSalary() * 0.10;
                    emp.increaseSalary(increment);
                }
            });
        });

        
        employees.forEach(Employee::printDetails);
    }
}


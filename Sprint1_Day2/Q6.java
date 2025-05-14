import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }

    public String toString() {
        return id + " | " + name + " | " + dept + " | ₹" + salary;
    }
}

public class Q6 {
    public static void main(String[] args) {
        TreeSet<Employee> empSet = new TreeSet<>();

        Employee employee1 = new Employee(101, "Ravi", "HR", 50000);
        Employee employee2 = new Employee(102, "Anjali", "IT", 60000);
        Employee employee3 =new Employee(103, "Suresh", "Finance", 55000);
        empSet.add(employee1);
        empSet.add(employee2);
        empSet.add(employee3);

        System.out.println("Employee in Sorted Order:");
        for (Employee e : empSet) {
            System.out.println(e);
        }
    }
}

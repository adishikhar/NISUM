package Sprint2_Day2;

import java.util.Optional;

class Employee {
    private int id;
    private String name;
    private Optional<String> email;      
    private Optional<String> department;  

    public Employee(int id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
        this.department = Optional.ofNullable(department);
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email.orElse("Not Provided"));
        System.out.println("Department: " + department.orElse("Not Assigned"));
        System.out.println();
    }
}

public class Q14 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Aditya", "adityashikhar7@gmail.com", "HR");
        Employee emp2 = new Employee(102, "Shikhar", null, null);

        emp1.print();
        emp2.print();
    }
}


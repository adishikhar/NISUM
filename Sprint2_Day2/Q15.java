package Sprint2_Day2;

import java.util.Optional;

class Employee {
    private int id;
    private String name;
    private Optional<String> address = Optional.empty();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = Optional.ofNullable(address);
    }

    public String Address() {
      
        return address.orElse("123 Default St, Default City");
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + Address());
        System.out.println();
    }
}

public class Q15 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Aditya");
        emp1.setAddress("kp12 KIIT, Bhubaneswar");

        Employee emp2 = new Employee(2, "Bob");
        

        emp1.print();
        emp2.print();
    }
}


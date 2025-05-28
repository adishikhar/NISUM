package Sprint2_Day2;

import java.util.*;
import java.util.stream.Collectors;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // getters
    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private Address address;

    public Employee(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Address getAddress() { return address; }
}

public class Q18 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "Shikhar", new Address("Bhubaneswar", "India")),
            new Employee("Richa", "Mishra", new Address("Ranchi", "India")),
            new Employee("Kritika", "Modi", new Address("Indore", "MP"))
        );

        Map<String, Address> AddressMap = employees.stream()
            .collect(Collectors.toMap(
                e -> e.getFirstName() + e.getLastName(),
                Employee::getAddress
            ));

        
        AddressMap.forEach((name, address) -> 
            System.out.println(name + " -> " + address)
        );
    }
}



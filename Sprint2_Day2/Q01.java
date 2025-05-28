package Sprint2_Day2;

import java.util.*;

class employee {
    String firstName;
    String lastName;

    employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

public class Q01 {
    public static void main(String[] args) {
        List<employee> employees = Arrays.asList(
            new employee("Aditya", "Shikhar"),
            new employee("Richa", "Mishra"),
            new employee("Kritika", "Modi")
        );

        Optional<String> Name = employees.stream()
            .findFirst() 
            .map(e -> e.firstName + " " + e.lastName);  

        Name.ifPresent(name -> System.out.println("Full name of first employee: " + name));
    }
}

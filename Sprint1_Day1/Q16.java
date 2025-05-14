package Sprint1_Day1;

class Nisum {
    String company = "Nisum India";
    String location = "Bhubaneswar";
}

class Employee extends Nisum {
    void showDetails() {
        System.out.println("Company: " + company);
        System.out.println("Location: " + location);
    }
}

public class Q16 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showDetails();
    }
}


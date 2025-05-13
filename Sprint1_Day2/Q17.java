package Sprint1_Day2;

class Base {
    public String name = "Base Class";
    protected int age = 30;
    private double salary = 50000;
    String city = "Delhi"; 

    static {
        System.out.println("Static block in Base");
    }

    void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        // System.out.println("Salary: " + salary); // private can't be accessed here
        System.out.println("City: " + city);
    }
}

class Child extends Base {
    void display() {
        System.out.println("Inside Child Class");
        show();
    }
}

public class Q17 {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}


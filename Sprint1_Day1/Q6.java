package Sprint1_Day1;

class Parent {
    static void showMessage() {
        System.out.println("Aditya");
    }
}

class Child extends Parent {
    
}

public class Q6 {
    public static void main(String[] args) {
        Child.showMessage();  // accessing static method from parent
    }
}


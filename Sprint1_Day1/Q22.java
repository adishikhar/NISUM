package Sprint1_Day1;

class Parent {
    void parentclass() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    void subclass() {
        System.out.println("child class");
    }
}

public class Q22 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.parentclass();     // we cant acess child class from parent obj

        Child c = new Child();
        c.subclass();     
    }
}


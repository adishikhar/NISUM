package Sprint1_Day1;

interface B {
    void print();
}

interface C {
    void show();
}

class A implements B, C {
    public void print() {
        System.out.println("Interface B");
    }

    public void show() {
        System.out.println("Interface C");
    }
}

public class Q23 {
    public static void main(String[] args) {
        A obj = new A();
        obj.print();
        obj.show();
    }
}


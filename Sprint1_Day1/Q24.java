package Sprint1_Day1;

interface call {
    static void A() {
        System.out.println("Static method in interface");
    }
}

public class Q24 {
    public static void main(String[] args) {
        call.A(); // I can call it with interface name
    }
}

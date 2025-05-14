package Sprint1_Day1;

class check {
    static {
        System.out.println("Static Block is executed");
    }

    static void print() {
        System.out.println("Static Method is executed");
    }
}

public class Q13 {
    public static void main(String[] args) {
        check.print();
    }
}


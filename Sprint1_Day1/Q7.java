package Sprint1_Day1;

class check {
    static int a = 10;

    static { 
        System.out.println("Static block executed");
    }

    static void display() {
        System.out.println("Static method called");
    }
}

public class Q7 {
    public static void main(String[] args) {
        System.out.println("Main method started");
        check.display();
    }
}

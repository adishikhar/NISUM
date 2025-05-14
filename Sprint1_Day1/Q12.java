package Sprint1_Day1;

class Test {
    int number = 10; // instance variable

    static void show() {
        // System.out.println(number); ❌ Error: can't access directly
        Test obj = new Test();
        System.out.println("Accessing via object: " + obj.number); // ✅
    }
}

public class Q12 {
    public static void main(String[] args) {
        Test.show();
    }
}


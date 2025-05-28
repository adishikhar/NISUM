interface InterfaceA {
    default void run() {
        System.out.println("Default run from InterfaceA");
    }
}

public class Q13 implements InterfaceA {
    @Override
    public void run() {
        System.out.println("Overridden run in Q13");
        
        InterfaceA.super.run();
    }

    public static void main(String[] args) {
        Q13 obj = new Q13();
        obj.run();
    }
}

interface InterfaceA {
    default void run() {
        System.out.println("Default run method from InterfaceA");
    }
}

public class Q12 implements InterfaceA {
    @Override
    public void run() {
        System.out.println("Overridden run method in Q12");
        
       
        InterfaceA.super.run();
    }

    public static void main(String[] args) {
        Q12 obj = new Q12();
        obj.run();
    }
}

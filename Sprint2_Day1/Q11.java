interface InterfaceA {
    default void run() {
        System.out.println("InterfaceA");
    }
}

interface InterfaceB {
    default void run() {
        System.out.println("InterfaceB");
    }
}

public class Q11 implements InterfaceA, InterfaceB {
    @Override
    public void run() {
        
        InterfaceA.super.run(); // this will call interfaceA 
        InterfaceB.super.run(); // this will call interfaceB
       
    }

    public static void main(String[] args) {
        Q11 obj = new Q11();
        obj.run();
    }
}

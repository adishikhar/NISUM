package Sprint1_Day1;

interface A {
    void outerMethod();

    interface nestedInterface {
        void innerMethod();
    }
}

class B implements A.nestedInterface {
    public void innerMethod() {
        System.out.println("From nested interface");
    }
}

public class Q25{
    public static void main(String[] args) {
        B t = new B();
        t.innerMethod();
    }
}


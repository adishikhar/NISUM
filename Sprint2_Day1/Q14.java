interface interfaceA {
    static int square(int x) {
        return x * x;
    }
}

public class Q14 {
    public static void main(String[] args) {
        int result = interfaceA.square(2);
        System.out.println("Square:" + result);
    }
}

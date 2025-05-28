import java.util.function.Function;

public class Q18 {
    public static void main(String[] args) {
        Function<String, String> toUpper = String::toUpperCase;

        String result = toUpper.apply("aditya");
        System.out.println("result: " + result);
    }
}

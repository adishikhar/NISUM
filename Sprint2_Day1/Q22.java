import java.util.*;
import java.util.function.Consumer;

public class Q22 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Aditya", "Shikhar", "Richa", "Mishra");

        Consumer<String> element = s -> System.out.println(s);

        str.forEach(element);
    }
}

import java.util.*;
import java.util.function.Consumer;

public class Q23 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> value = n -> System.out.println(n * 2);

        
        number.forEach(value);
    }
}

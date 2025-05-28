import java.util.*;
import java.util.function.Predicate;

public class Q07 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));

       
        Predicate<Integer> isEven = num -> num % 2 == 0;

        
        numbers.removeIf(isEven);

        System.out.println("After removing evens: " + numbers);  
    }
}

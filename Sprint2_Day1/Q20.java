import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q20 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        Predicate<Integer> divisibleBy2 = n -> n % 2 == 0;
        Predicate<Integer> divisibleBy3 = n -> n % 3 == 0;

        List<Integer> divisibleBy2And3 = numbers.stream()
                .filter(divisibleBy2.and(divisibleBy3))
                .collect(Collectors.toList());

        System.out.println("Divisible by 2 and 3: " + divisibleBy2And3);

        List<Integer> divisibleBy2Or3 = numbers.stream()
                .filter(divisibleBy2.or(divisibleBy3))
                .collect(Collectors.toList());

        System.out.println("Divisible by 2 or 3: " + divisibleBy2Or3);
    }
}

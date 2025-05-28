import java.util.function.Supplier;
import java.util.stream.Stream;

public class Q21 {
    public static void main(String[] args) {
        Supplier<Double> random = Math::random;

        Stream.generate(random)
              .limit(5)
              .forEach(System.out::println);
    }
}

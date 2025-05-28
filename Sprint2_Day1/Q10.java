import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        List<String> word = Arrays.asList("car", "bus", "cycle", "aditya", "shikhar");

        word.sort(Comparator.comparingInt(String::length));

        System.out.println("Sorted by length: " + word);
    }
}

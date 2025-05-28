import java.util.*;

public class Q17 {
    public static void main(String[] args) {
        List<String> word = Arrays.asList("aditya", "richa", "bus", "carry", "tag");

        word.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println("Sorted: " + word);
    }
}

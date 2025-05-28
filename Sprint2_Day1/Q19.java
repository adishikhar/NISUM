import java.util.*;
import java.util.stream.Collectors;

public class Q19 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Aditya", "Richa", "Shikhar", "Abhinav", "Kritika");

        List<String> startsWithA = str.stream()
                                        .filter(name -> name.startsWith("A"))
                                        .collect(Collectors.toList());

        System.out.println("Names starting with A: " + startsWithA);
    }
}

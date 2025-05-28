

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q05 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Aditya", "Jack", "Shikhar", "Joker");

        
        Predicate<String>  check= name -> name.startsWith("J");

        // Filter the list using the predicate
        List<String> filtered = names.stream()
                                     .filter(check)
                                     .collect(Collectors.toList());

        System.out.println(filtered);  
    }
}

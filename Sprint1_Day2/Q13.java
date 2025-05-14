import java.util.*;

public class Q13 {
    public static void main(String[] args) {
        String fruit1 = "apple";
        String fruit2 = "banana";
        String fruit3 = "cherry";
        String fruit4 = "mango";

        String fruit5 = "banana";
        String fruit6 = "kiwi";
        String fruit7 = "mango";
        String fruit8 = "apple";

        List<String> list1 = new ArrayList<>();
        list1.add(fruit1);
        list1.add(fruit2);
        list1.add(fruit3);
        list1.add(fruit4);

        List<String> list2 = new ArrayList<>();
        list2.add(fruit5);
        list2.add(fruit6);
        list2.add(fruit7);
        list2.add(fruit8);

        List<String> common = new ArrayList<>();
        common.addAll(list1);
        common.retainAll(list2);

        System.out.println("Common Elements: " + common);
    }
}

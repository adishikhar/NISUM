import java.util.*;

public class Q12 {
    public static void main(String[] args) {
       

        int[] nums = {5, 2, 8, 5, 2, 9, 1};

        TreeSet<Integer> sortedSet = new TreeSet<>();

        for (int num : nums) {
            sortedSet.add(num);
        }

        System.out.println("Sorted Unique Elements: " + sortedSet);
    }
}

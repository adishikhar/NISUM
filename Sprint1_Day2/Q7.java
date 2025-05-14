import java.util.*;

public class Q7 {

    public static void main(String[] args) {
        
        
        String text = "Java is easy. Java is powerful, and Java is everywhere!";

        
        text = text.toLowerCase();  
        text = text.replaceAll("[^a-zA-Z ]", "");  
        
        String[] words = text.split(" ");  
        
        HashMap<String, Integer> map = new HashMap<>();

        
        for (String word : words) {
            if (map.containsKey(word)) {
                
                map.put(word, map.get(word) + 1);
            } else {
                
                map.put(word, 1);
            }
        }

       
        System.out.println("Frequencies:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

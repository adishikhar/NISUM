package Sprint1_Day1;

public class Q30 {
    public static void main(String[] args) {
        String str = "My name is Aditya Shikhar";

        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}


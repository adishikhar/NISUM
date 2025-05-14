import java.util.*;

public class Q5 {

    Stack<String> history = new Stack<>(); 
    void add(String url) {
        history.push(url);
        System.out.println(url +" added in the history");
    }

    void back() {
        if (!history.isEmpty()) {
            System.out.println("Back page: " + history.pop());
        } else {
            System.out.println("No previous page.");
        }
    }

    void currentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No page visited");
        }
    }

    void showHistory() {
        System.out.println("All History:");
        for (String url : history) {
            System.out.println(url);
        }
    }

    public static void main(String[] args) {
        Q5 obj = new Q5();  

        obj.add("google.com");
        obj.add("youtube.com");
        obj.currentPage();
        obj.back();
        obj.currentPage();
        obj.showHistory();
    }
}

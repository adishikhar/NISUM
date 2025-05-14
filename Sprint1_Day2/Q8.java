import java.util.*;

class MenuItem {
    String name;
    String description;
    double price;

    MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String toString() {
        return name + " - ₹" + price + " (" + description + ")";
    }
}

public class Q8 {

    public static void main(String[] args) {

        LinkedHashMap<String, HashMap<String, MenuItem>> menu = new LinkedHashMap<>();

        HashMap<String, MenuItem> starters = new HashMap<>();
        HashMap<String, MenuItem> mainCourse = new HashMap<>();
        HashMap<String, MenuItem> desserts = new HashMap<>();

        MenuItem item1 = new MenuItem("Samosa", "Crispy fried", 20);
        MenuItem item2 = new MenuItem("Paneer Butter Masala", "Creamy curry", 180);
        MenuItem item3 = new MenuItem("Gulab Jamun", "Sweet balls", 50);

        starters.put("Samosa", item1);
        mainCourse.put("Paneer Butter Masala", item2);
        desserts.put("Gulab Jamun", item3);

        menu.put("Starters", starters);
        menu.put("Main Course", mainCourse);
        menu.put("Desserts", desserts);

        for (String category : menu.keySet()) {
            System.out.println(category);
            HashMap<String, MenuItem> items = menu.get(category);
            for (String itemName : items.keySet()) {
                MenuItem item = items.get(itemName);
                System.out.println(item);
            }
        }
    }
}

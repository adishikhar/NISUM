import java.util.*;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class Q1 {
    ArrayList<Item> cart;

    Q1() {
        cart = new ArrayList<>();
    }

    void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        cart.add(newItem);
    }

    void removeItem(String name) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equalsIgnoreCase(name)) {
                cart.remove(i);
            }
        }
    }

    void viewCart() {
        for (Item item : cart) {
            System.out.println(item.name + item.price + " x " + item.quantity);
        }
    }

    void calculateTotal() {
        double total = 0;
        for (Item item : cart) {
            total += item.price * item.quantity;
        }
        System.out.println("Total:" + total);
    }

    public static void main(String[] args) {
        Q1 myCart = new Q1();

        myCart.addItem("Shoes", 1500, 2);
        myCart.addItem("Shirt", 800, 1);

        myCart.viewCart();
        myCart.calculateTotal();

        myCart.removeItem("Shoes");
        myCart.viewCart();
    }
}

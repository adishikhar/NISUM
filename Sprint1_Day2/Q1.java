

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
    static ArrayList<Item> cart = new ArrayList<>();

    static void addItem(String name, double price, int quantity) {
        cart.add(new Item(name, price, quantity));
    }

    static void removeItem(String name) {
        cart.removeIf(item -> item.name.equalsIgnoreCase(name));
    }

    static void viewCart() {
        for (Item item : cart) {
            System.out.println(item.name + " - ₹" + item.price + " x " + item.quantity);
        }
    }

    static void calculateTotal() {
        double total = 0;
        for (Item item : cart) {
            total += item.price * item.quantity;
        }
        System.out.println("Total: ₹" + total);
    }

    public static void main(String[] args) {
        addItem("Shoes", 1500, 2);
        addItem("Shirt", 800, 1);
        viewCart();
        calculateTotal();
        removeItem("Shoes");
        viewCart();
    }
}


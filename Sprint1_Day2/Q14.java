import java.util.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " | " + category + " | ₹" + price;
    }
}


class ProductSorter implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        int catCompare = p1.category.compareTo(p2.category);
        if (catCompare == 0) {
            
            return Double.compare(p1.price, p2.price);
        } else {
            return catCompare;
        }
    }
}

public class Q14 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product pd1 = new Product("Laptop", "Electronics", 55000);
        Product pd2 = new Product("Shampoo", "Cosmetics", 250);
        Product pd3 = new Product("Phone", "Electronics", 30000);
        Product pd4 = new Product("Lipstick", "Cosmetics", 450);

        products.add(pd1);
        products.add(pd2);
        products.add(pd3);
        products.add(pd4);

        Collections.sort(products, new ProductSorter());

        System.out.println("Sorted Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

import java.util.*;

public class Q4{
    
    HashMap<String, Integer> products = new HashMap<>();

    
    void addProduct(String name, int qty) {
        products.put(name, qty);
    }

    void updateProduct(String name, int qty) {
        products.put(name, qty);
    }

    void removeProduct(String name) {
        products.remove(name);
    }

    void checkStock(String name) {
        if (products.containsKey(name)) {
            System.out.println( "Product is in stock ");
        } else {
            System.out.println("Product is not in stock");
        }
    }

    public static void main(String[] args) {
        
        Q4 obj = new Q4();

        
        obj.addProduct("Laptop", 10);
        obj.addProduct("Mouse", 20);
        obj.checkStock("Laptop");

        obj.updateProduct("Laptop", 5);
        obj.checkStock("Laptop");

        obj.removeProduct("Mouse");
        obj.checkStock("Mouse");
    }
}

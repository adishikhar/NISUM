package Sprint1_Day1;

class eCart {
    String itemName;
    double itemValue;
    int itemId;

    eCart(String itemName, int itemValue, int itemId){
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemId = itemId;
    }
}

public class Q4 {
    public static void main(String[] args) {
        eCart c1 = new eCart("Shoes", 1500, 101);
    

        eCart c2 = new eCart("Bag",1200,102);
        

        double total = 0;
        int count = 0;

        if (c1.itemValue > 0) {
            total += c1.itemValue;
            count++;
        }
        if (c2.itemValue > 0) {
            total += c2.itemValue;
            count++;
        }

        System.out.println("Total Items: " + count);
        System.out.println("Total amount: ₹" + total);
    }
}


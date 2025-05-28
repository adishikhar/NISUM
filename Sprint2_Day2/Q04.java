package Sprint2_Day2;

public class Q04 {
    public static void main(String[] args) {
        String storeId = "29";

        String pad = String.format("%4s", storeId).replace(' ', '0');

        System.out.println(pad);  
    }
}

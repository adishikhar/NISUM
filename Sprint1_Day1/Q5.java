package Sprint1_Day1;

class UserDetails {
    public String name;
    public int id;
    public String email;
    private String creditCard;
    private double creditCardBalance;

    // getter method : we can access the private variable from outside the class
    public String getCreditCard() {
        return creditCard;
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }
}

public class Q5 {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.name = "Aditya";
        user.id = 123;
        user.email = "adityashikhar7@gmail.com";

        System.out.println("Name: " + user.name);
        System.out.println("ID: " + user.id);
        System.out.println("Email: " + user.email);
    }
}


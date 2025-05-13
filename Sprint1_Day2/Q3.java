package Sprint1_Day2;

class User {
    String name;
    String email;
    int age;
}

public class Q3 {
    public static void main(String[] args) {
        User u = new User();
        u.name = "Aditya";
        u.email = "adityashikhar7@gmail.com";
        u.age = 21;

        System.out.println("User Profile :");
        System.out.println("Name: " + u.name);
        System.out.println("Email: " + u.email);
        System.out.println("Age: " + u.age);
    }
}

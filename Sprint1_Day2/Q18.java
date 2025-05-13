package Sprint1_Day2;

class User {
    private static User instance = null;
    String name;

    private User() {
        name = "Singleton User";
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    void show() {
        System.out.println("User Name: " + name);
    }
}

public class Q18 {
    public static void main(String[] args) {
        User u1 = User.getInstance();
        User u2 = User.getInstance();

        u1.show();
        System.out.println("Are both objects same? " + (u1 == u2)); // true
    }
}

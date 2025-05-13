package Sprint1_Day2;

class check {
    static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    static boolean isValidPassword(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;


        for (int i=0; i<=password.length()-1; i++){
            char ch =password.charAt(i);
            if (Character.isLetter(ch) == true)
             hasLetter = true;
            else if 
            (Character.isDigit(ch)== true) hasDigit = true;
            else 
            hasSpecial = true;


        }

        return hasLetter && hasDigit && hasSpecial;
    }
}

public class Q11 {
    public static void main(String[] args) {
        String username = "adityashikhar7@gmail.com";
        String password = "Aditya@123";

        if (check.isValidEmail(username) && check.isValidPassword(password)== true) {
            System.out.println("Valid username and password");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}


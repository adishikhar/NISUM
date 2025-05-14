import java.util.HashSet;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> emailSet = new HashSet<>();

        
        String ch  = "y";
        do{
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            emailSet.add(email);

            System.out.print("Do you want to add more email(y/n): ");
            ch = sc.nextLine();

        }while(ch.equalsIgnoreCase("y"));

        // Display unique emails
        System.out.println("All unique Email:");
        for (String email : emailSet) {
            System.out.println(email);
        }

    sc.close();
    }
}


package Q7;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GlobalException {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter("error.txt", true))) {
                writer.println("Error: " + ex.getMessage());
            } catch (IOException e) {
                System.out.println("Failed");
            }
        });

        
        int x = 299 / 0;  
    }
}

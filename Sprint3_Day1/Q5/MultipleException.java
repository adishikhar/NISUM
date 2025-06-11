package Q5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MultipleException  {

    public static void ParseInt(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); 
                int num = Integer.parseInt(line); 
                System.out.println("Parsed: " + num);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ParseInt("file.txt");  
    }
}

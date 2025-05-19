package org.example;

import java.sql.*;
import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter partial name: ");
        String input = sc.nextLine();

        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);

            String query = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, input + "%");

            ResultSet rs = ps.executeQuery();
            System.out.println("Matched Students:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age"));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


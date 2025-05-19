package org.example;

import java.sql.*;

public class Q3 {
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age"));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

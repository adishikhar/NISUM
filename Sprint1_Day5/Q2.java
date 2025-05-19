package org.example;

import java.sql.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();


            String sql = "INSERT INTO students VALUES (1, 'Aditya', 21)";
            statement.executeUpdate(sql);

            System.out.println("Student inserted successfully.");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

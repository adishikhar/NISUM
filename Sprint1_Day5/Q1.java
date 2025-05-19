package org.example;


import java.sql.*;

public class Q1 {
    public static void main(String[] args) throws SQLException{
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection successful");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

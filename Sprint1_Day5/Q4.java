package org.example;

import java.sql.*;

public class Q4 {
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);

            String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "Ramesh");
            ps.setInt(3, 22);

            ps.executeUpdate();
            System.out.println("Student inserted using PreparedStatement");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
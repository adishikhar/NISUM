package org.example;

import java.sql.*;

public class Q5 {
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);

            String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "Updated Name");
            ps.setInt(2, 25);
            ps.setInt(3, 1);

            ps.executeUpdate();
            System.out.println("Student updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
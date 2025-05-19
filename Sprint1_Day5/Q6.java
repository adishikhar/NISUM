package org.example;

import java.sql.*;

public class Q6 {
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 2);

            ps.executeUpdate();
            System.out.println("Student deleted successfully.");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

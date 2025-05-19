package org.example;

import java.sql.*;

public class Q8 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "Shikhar@123";

            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

            // First insert into students table
            String insertStudent = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement ps1 = connection.prepareStatement(insertStudent);
            ps1.setInt(1, 2);
            ps1.setString(2, "Ankit");
            ps1.setInt(3, 21);
            ps1.executeUpdate();

            // Second insert into enrollments table
            String insertEnroll = "INSERT INTO enrollments (student_id, course_id, grade) VALUES (?, ?, ?)";
            PreparedStatement ps2 = connection.prepareStatement(insertEnroll);
            ps2.setInt(1, 3);
            ps2.setInt(2, 101);
            ps2.setString(3, "A");
            ps2.executeUpdate();

            connection.commit(); //
            System.out.println("Transaction done successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back.");
                }
            } catch (Exception ex) {
                System.out.println("Rollback failed: " + ex.getMessage());
            }

        }
    }
}

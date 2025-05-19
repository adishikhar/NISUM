package org.example;

import java.sql.*;

public class Q10 {
    public static void main(String[] args) {

        // Declare non-resource variables outside
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Shikhar@123";

        // try-with-resources to auto-close JDBC resources
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()
        ) {
            // Intentional SQL error to trigger exception
            String query = "SELEC * FROM students"; // wrong SELECT
            statement.execute(query);

        } catch (SQLException e) {
            System.out.println("SQL Exception caught!");
            System.out.println("Message   : " + e.getMessage());
            System.out.println("SQLState  : " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }
}

package org.example;

import java.sql.*;

public class Q10 {
    public static void main(String[] args) {

        
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Shikhar@123";

        
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()
        ) {
            
            String query = "SELEC * FROM students";
            statement.execute(query);

        } catch (SQLException e) {
            System.out.println("SQL Exception caught!");
            System.out.println("Message   : " + e.getMessage());
            System.out.println("SQLState  : " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }
}

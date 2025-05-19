package org.example;

import java.sql.*;
import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        try {
            String url ="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="Shikhar@123";
            Connection connection = DriverManager.getConnection(url,username,password);


            CallableStatement cs = connection.prepareCall("{ call getStudentById(?) }");
            cs.setInt(1, id);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            } else {
                System.out.println("No student found with that ID.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



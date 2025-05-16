package Sprint1_Day3;

import java.sql.*;

public class Q03 {
    public static void main(String[] args) {
        

        try {
            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "password"
            );

            // Insert function
            String insert = "INSERT INTO students (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatementInsert = connect.prepareStatement(insert);
            preparedStatementInsert.setInt(1, 10);
            preparedStatementInsert.setString(2, "Aditya");
            preparedStatementInsert.setString(3, "aditya@gmail.com");
            boolean InsertResult = preparedStatementInsert.executeUpdate() > 0;
            System.out.println("Insert: " + InsertResult);

            // Update funcntion
            String update = "UPDATE students SET name = ?, email = ? WHERE id = ?";
            PreparedStatement preparedStatementUpdate = connect.prepareStatement(update);
            preparedStatementUpdate.setString(1, "Aditya shikhar");
            preparedStatementUpdate.setString(2, "adityashikhar@gmail.com");
            preparedStatementUpdate.setInt(3, 10);
            boolean UpdateResult = preparedStatementUpdate.executeUpdate() > 0;
            System.out.println("Update: " + UpdateResult);

            // Delete function
            String delete = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatementDelete = connect.prepareStatement(delete);
            preparedStatementDelete.setInt(1, 10);
            boolean deleteSuccess = preparedStatementDelete.executeUpdate() > 0;
            System.out.println("Delete: " + deleteSuccess);

        } catch (Exception e) {
            System.out.println("Error: ");
        }
    }
}


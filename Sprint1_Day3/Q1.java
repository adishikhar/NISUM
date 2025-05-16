package Sprint1_Day3;

import java.sql.*;

public class Q1 {
    public static void main(String[] args) throws SQLException{
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "Shikhar@123";
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful");
        }
    }

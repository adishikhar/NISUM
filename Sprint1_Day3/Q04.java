package Sprint1_Day3;

import java.sql.*;

public class Q04 (
public static void main(String[] args) throws SQLException {
    

String url = "jdbc:mysql://localhost:3306/transaction";
String user = "root";
String possword = "Shikhar@123";


Connection connection = DriverManager.getConnection(url, user, password);
Statement statement = connection.createStatement;


System.out.println("Data before transaction");


ResultSet rs = statement.executeQuery(  "SELECT * FROM ACCOUNTS");


while (rs.next()) {


System.out.println(rs.getInt( "ID") + " " + rs.getString( "NAME") +" " + rs.getInt(  "BALANCE"));



connection.setAutoCommit(false);


try {
statement.executeUpdate( "UPDATE ACCOUNTS SET BALANCE = BALANCE - 100 WHERE NAME = 'Aditya'");


//Simulating on error
//System.out.println("Something bad happens"); // IF this is executed then it will throw an error and the rollback queries is executed.
//if (true) throw new RuntimeException("Simulated error");


statement.executeUpdate( "UPDATE ACCOUNTS SET BALANCE = BALANCE + 100 WHERE NAME = 'Shikhar ");


connection.commit();


System.out.println("Transaction is committed");

catch (Exception e) {


System.out.println("Transaction is being rolled back");
connection.rollback();
}

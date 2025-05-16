package Sprint1_Day3;

import java.sql.*;

public class Q05 {
    public static void main(String[] args) {
         
            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "Shikhar@123"
            );

            int studentId = 1; 

            String query = "SELECT c.course_name, c.instructor, e.grade " +
                           "FROM courses c " +
                           "JOIN enrollments e ON c.id = e.course_id " +
                           "WHERE e.student_id = ?";

            PreparedStatement ps = Connection connect.prepareStatement(query);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();
            System.out.println("Courses enrolled by student ID: " + studentId);
            
            

            while (rs.next()) {
                System.out.println(rs.getString("course_name"));
                System.out.println(rs.getString("instructor"));
                System.out.println(rs.getString("grade"));
               
            }

        } 
        
    }


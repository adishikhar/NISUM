import java.sql.*;

class Student {
    int id;
    String name;
    String email;

    Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

public class Q02 {
    public static void main(String[] args) {
        Student student = null;
         

        try {
            connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "Shikhar@123"
            );

            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 1); 

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                student = new Student(id, name, email);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (student != null) {
            student.display(); 
        } else {
            System.out.println("Student not found.");
        }
    }
}

package Sprint1_Day3;

import java.sql.*;
import java.util.*;


public class Q06 {
    public static void main(String[] args) {
         

        
        String category = "FAN"; 
        Double minPrice = 500.0;        
        Double maxPrice = 10000.0;       

        try {
            
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "Shikhar@123"
            );

            
            StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
            List<Object> list = new ArrayList<>();

            if (category != null) {
                query.append(" AND category = ?");
                list.add(category);
            }
            if (minPrice != null) {
                query.append(" AND price >= ?");
                list.add(minPrice);
            }
            if (maxPrice != null) {
                query.append(" AND price <= ?");
                list.add(maxPrice);
            }

            PreparedStatement ps = connect.prepareStatement(query.toString());

            for (int i = 0; i < list.size(); i++) {
                ps.setObject(i + 1, list.get(i));
            }

            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                System.out.println("Product: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Category: " + rs.getString("category"));
                
            }

        } catch (Exception e) {
            System.out.println("Error ");
        }
    }
}


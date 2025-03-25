/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class tables {
    public static void main(String[]args)
    {
        Connection con = null;
        Statement st = null;
        try {
            // Get the database connection
            con = ConectionProvider.getCon();
            
            // Check if the connection is null
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database!");
                return;
            }
            
            // Create a SQL statement
            st = con.createStatement();
            
//             Execute the CREATE TABLE query
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "name VARCHAR(200), " +
                "email VARCHAR(200), " +
                "password VARCHAR(50), " +
                "securityQuestion VARCHAR(500), " +
                "answer VARCHAR(100), " +
                "address VARCHAR(100), " +
                "status VARCHAR(20)" +
                ")"
            );
               st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS room (" +
                "roomNo VARCHAR(10), " +
                "roomType VARCHAR(200), " +
                "bed VARCHAR(200), " +
                "price INT, " +
                "status VARCHAR(20)" +
                ")"
            );
           String createCustomerTable = 
                "CREATE TABLE IF NOT EXISTS customer (" +
                "id INT, " +
                "name VARCHAR(200), " +
                "mobileNumber VARCHAR(20), " +
                "nationality VARCHAR(200), " +
                "gender VARCHAR(200), " +
                "email VARCHAR(200), " +
                "idProof VARCHAR(200), " +
                "address VARCHAR(200), " +
                "checkIn VARCHAR(50), " +
                "roomNo VARCHAR(10), " +
                "bed VARCHAR(200), " +
                "roomType VARCHAR(200), " +
                "pricePerDay INT, " +
                "numberofDaysStay INT, " +
                "totalAmount VARCHAR(200), " +
                "checkout VARCHAR(50)" +
                ")";
            st.executeUpdate(createCustomerTable);
            
            // Show success message
           
            JOptionPane.showMessageDialog(null, "Table created successfully!");
            
        } catch (Exception e) {
            // Print the exception for debugging
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Close the resources
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

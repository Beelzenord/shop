/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklas
 */
public class CreateOrderDB {
    
    public static boolean executeOrder(Connection on, Hashtable table, int orderID) {
        PreparedStatement updateTables = null;
        PreparedStatement removeOrder = null;
        Enumeration e = table.keys();
    }
    
    public static boolean createOrder(Connection con, Hashtable table, String username) {
        PreparedStatement pst = null;
        PreparedStatement orderIdPrep = null;
        ResultSet rs = null;
        Enumeration e = table.keys();
        
        try {
            pst = con.prepareStatement(createOrderPrepStatement());
            orderIdPrep = con.prepareStatement(createOrderDetailsPrepStatement(), PreparedStatement.RETURN_GENERATED_KEYS);
            
            con.setAutoCommit(false);
            orderIdPrep.executeUpdate();
            rs = orderIdPrep.getGeneratedKeys();
            int orderID = 0;
            if (rs.next())
                orderID = rs.getInt(1);
            
            while (e.hasMoreElements()) {
                String s = (String)e.nextElement();
                Hashtable tmp = (Hashtable)table.get(s);
                String tableName = null;
                if (s.contains("Shoes"))
                    tableName = "shoeClass";
                else if (s.contains("Shirt"))
                    tableName = "shirtClass";
                else if (s.contains("Gloves"))
                    tableName = "glovesClass";
                else if (s.contains("Pants"))
                    tableName = "pantsClass";
                pst.setInt(1, orderID);
                pst.setInt(2, (int)tmp.get("id"));
                pst.setString(3, tableName);
                pst.setInt(4, (int)tmp.get("amount"));
                pst.setString(5, username);
                pst.executeUpdate();
            }
            con.commit();
            con.setAutoCommit(true);
            rs.close();
            pst.close();
            orderIdPrep.close();
        } catch (SQLException ex) {
            System.out.println("DID NOT COMMIT");
            try {
                con.rollback();
                return false;
            } catch (SQLException ex1) {
            }
            return false;
        }
        System.out.println("WORKING");
        return true;
    }
    
    private static String createOrderDetailsPrepStatement() {
        return "INSERT INTO orders (orderID) values(null)";
    }
    
    private static String createOrderPrepStatement() {
        return "INSERT INTO orderDetails (orderID, id, tableName, amount, username) "
                + "VALUES((SELECT orderID FROM orders WHERE orderID = ?), ?, ?, ?, ?)";
    }
}

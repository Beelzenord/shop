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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklas
 */
public class CreateOrderDB {
    
    public static void createOrder(Connection con, Hashtable table, String username) {
        ;
        PreparedStatement pst = null;
        try {
             pst = con.prepareStatement(createPrepStatement());
        } catch (SQLException ex) {
        }
        Enumeration e = table.keys();
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
            try {
                pst.setInt(1, (int)tmp.get("id"));
                pst.setString(2, tableName);
                pst.setInt(3, (int)tmp.get("amount"));
                pst.setString(4, username);
                pst.addBatch();
            } catch (SQLException ex) {
                Logger.getLogger(CreateOrderDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            pst.executeBatch();
        } catch (SQLException ex) {
        }
    }
    
    private static String createPrepStatement() {
        return "INSERT INTO orders (id, tableName, amount, username) "
                + "VALUES(?, ?, ?, ?)";
    }
}

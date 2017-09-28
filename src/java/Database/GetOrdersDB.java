/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import businesslogic.Gloves;
import businesslogic.Orders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Niklas
 */
public class GetOrdersDB extends Orders {
    
    private GetOrdersDB(int orderID, int id, String tableName,  int amount,  String username) {
        super(orderID, id, tableName, amount, username);
    }
    
    public static Collection searchItems(String group, Connection con) {
        Vector v = new Vector();
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * FROM orderDetails ORDER BY orderID");
        } catch (SQLException ex) {
            System.out.println("could not query");
        }
        try {
            while (rs.next()) {
                int orderID = rs.getInt(1);
                int id = rs.getInt(2);
                String tableName = rs.getString(3);
                int amount = rs.getInt(4);
                String username = rs.getString(5);
                v.addElement(new GetOrdersDB(orderID, id, tableName, amount, username));
            }
        } catch (SQLException ex) {
            System.out.println("could not rs");
        }
        return v;
    }
}
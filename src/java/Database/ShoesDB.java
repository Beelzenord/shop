/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import businesslogic.Shoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklas
 */

public class ShoesDB extends Shoes {
    
    private ShoesDB(int id, String name, float price, int stock) {
        super(id, name, price, stock);
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
            rs = st.executeQuery("select * from shoeClass");
        } catch (SQLException ex) {
        }
        try {
            while (rs.next()) {
                int i = rs.getInt(1);
                String itemName = rs.getString(2);
                float price = rs.getFloat(3);
                int stock = rs.getInt(4);
                v.addElement(new ShoesDB(i, itemName, price, stock));
            }
        } catch (SQLException ex) {
        }
        return v;
    }
}






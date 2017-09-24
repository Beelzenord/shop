/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import businesslogic.Item;
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
public class DBItem extends Item {
    
    private DBItem(int id, String name, int price) {
        super(id, name, price);
    }
    
    /** Not using this currently **/
    public static Collection searchItems(String group) {
        Vector v = new Vector();
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kTunes?useSSL=false", "asd", "asd");
        } catch (SQLException ex) {
        }
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("select item_id, name from Item where item_group = "+group);
        } catch (SQLException ex) {
        }
        try {
            while (rs.next()) {
                int i = rs.getInt("item_id");
                String name = rs.getString("name");
                int p = rs.getInt("price");
                v.addElement(new DBItem(i, name, p));
            }
        } catch (SQLException ex) {
        }
        return v;
    }
}

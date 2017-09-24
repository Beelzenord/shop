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

/**
 *
 * @author Niklas
 */

public class ShirtDB extends Shoes {
    
    private ShirtDB(int id, String name, String brand, int price, int rating, int stock) {
        super(id, name, brand, price, rating, stock);
    }
    
    public static Collection searchItems(String group) {
        Vector v = new Vector();
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "admin1", "admin1p");
        } catch (SQLException ex) {
        }
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from T_Shirt");
        } catch (SQLException ex) {
        }
        try {
            while (rs.next()) {
                int i = rs.getInt("shirtId");
                String itemName = rs.getString("itemName");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                int rating = rs.getInt("rating");
                int stock = rs.getInt("stock");
                v.addElement(new ShirtDB(i, itemName, brand, price, rating, stock));
            }
        } catch (SQLException ex) {
        }
        return v;
    }
}
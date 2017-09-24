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
    
    private ShoesDB(int id, String name, String brand, int price, int rating, int stock) {
        super(id, name, brand, price, rating, stock);
    }
    
    public static Collection searchItems(String group, Connection con) {
        Vector v = new Vector();
        /*Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "admin1", "admin1p");
        } catch (SQLException ex) {
        }*/
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from T_Shoes");
        } catch (SQLException ex) {
        }
        try {
            while (rs.next()) {
                int i = rs.getInt("shoesId");
                String itemName = rs.getString("itemName");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                int rating = rs.getInt("rating");
                int stock = rs.getInt("stock");
                v.addElement(new ShoesDB(i, itemName, brand, price, rating, stock));
            }
        } catch (SQLException ex) {
        }
        return v;
    }
}






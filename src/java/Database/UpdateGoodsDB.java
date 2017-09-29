/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklas
 */
public class UpdateGoodsDB {
    
    
    public static void updateGoods(Connection con, int id, String tableName, String name, float price, int stock) {
        PreparedStatement updateGoodsPrep = null;
        try {
            updateGoodsPrep = con.prepareStatement(createUpdateGoodsPrepStatement(tableName));
            updateGoodsPrep.setString(1, name);
            updateGoodsPrep.setFloat(2, price);
            updateGoodsPrep.setInt(3, stock);
            updateGoodsPrep.setInt(4, id);
            updateGoodsPrep.executeUpdate();
            
        } catch (SQLException ex) {
        } finally {
            if (updateGoodsPrep != null)
                try {
                    updateGoodsPrep.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public static void insertGoods(Connection con, String tableName, String name, float price, int stock) {
        PreparedStatement insertGoodsPrep = null;
        try {
            insertGoodsPrep = con.prepareStatement(createInsertGoodsPrepStatement(tableName));
            insertGoodsPrep.setString(1, name);
            insertGoodsPrep.setFloat(2, price);
            insertGoodsPrep.setInt(3, stock);
            insertGoodsPrep.executeUpdate();
            
        } catch (SQLException ex) {
        } finally {
            if (insertGoodsPrep != null)
                try {
                    insertGoodsPrep.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    private static String createUpdateGoodsPrepStatement(String tableName) {
        return "UPDATE "+tableName+" SET name = ?, price = ?, stock = ? WHERE id = ?";
    }
    
    private static String createInsertGoodsPrepStatement(String tableName) {
        return "INSERT INTO "+tableName+" (name, price, stock) VALUES(?, ?, ?)";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.GetOrdersDB;
import Database.PantsDB;
import java.sql.Connection;
import java.util.Collection;

/**
 *
 * @author Niklas
 */
public class Orders {
    private int orderID;
    private int id;
    private String tableName;
    private int amount;
    private String username;

    public Orders(int orderID, int id, String tableName, int amount, String username) {
        this.orderID = orderID;
        this.id = id;
        this.tableName = tableName;
        this.amount = amount;
        this.username = username;
    }
    
    static public Collection searchItems(String group, Connection con) {
        return GetOrdersDB.searchItems(group, con);
    }

    public int getOrderID() {
        return orderID;
    }

    public int getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }

    public int getAmount() {
        return amount;
    }

    public String getUsername() {
        return username;
    }
    
}

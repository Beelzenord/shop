/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.ItemDB;
import java.sql.Connection;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Niklas
 */
public class Item {
    private int id;
    private String name;
    private double price;
    private int stock;
    /*static public Collection searchItems(String group, Connection con) {
        return ItemDB.searchItems(group, con);
    }*/

    public Item(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    
    
}

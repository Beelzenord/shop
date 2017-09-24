/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.ShirtDB;
import java.util.Collection;

/**
 *
 * @author Niklas
 */

public class Shirt {
    private int id;
    private String itemName;
    private String brand;
    private int price;
    private int rating;
    private int stock;
    
    static public Collection searchItems(String group) {
        return ShirtDB.searchItems(group);
    }

    public Shirt(int id, String name, String brand, int price, int rating, int stock) {
        this.id = id;
        this.itemName = name;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }
    
    

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.ShirtDB;
import Database.ShoesDB;
import java.sql.Connection;
import java.util.Collection;

/**
 *
 * @author fauzianordlund
 */
public class Shirt extends Item{
    
    static public Collection searchItems(String group, Connection con) {
        return ShirtDB.searchItems(group, con);
    }
    
    public Shirt(int id, String name, int price, int stock) {
        super(id, name, price, stock);
    }
}
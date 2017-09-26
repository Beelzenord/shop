/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.GlovesDB;
import java.sql.Connection;
import java.util.Collection;

/**
 *
 * @author fauzianordlund
 */
public class Gloves extends Item {
    
        static public Collection searchItems(String group, Connection con) {
        return GlovesDB.searchItems(group, con);
    }
        
    public Gloves(int id, String name, float price, int stock) {
        super(id, name, price, stock);
    }
    
}

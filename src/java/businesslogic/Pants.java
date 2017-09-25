/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import Database.PantsDB;
import java.sql.Connection;
import java.util.Collection;

/**
 *
 * @author fauzianordlund
 */
public class Pants extends Item{
    
    static public Collection searchItems(String group, Connection con) {
        return PantsDB.searchItems(group, con);
    }
        
    public Pants(int id, String name, int price, int stock) {
        super(id, name, price, stock);
    }
    
}

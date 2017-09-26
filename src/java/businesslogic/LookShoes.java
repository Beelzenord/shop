/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.sql.Connection;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Niklas
 */
public class LookShoes {

    public LookShoes() {
    }
    
    public Hashtable getShoesWithGroup(String s, Connection con) {
        Collection c = Shoes.searchItems(s, con);
        Hashtable t = new Hashtable();
        t.put("size", c.size());
        Iterator it = c.iterator();
        for (int i = 0; it.hasNext(); i++) {
            Hashtable items = new Hashtable();
            Shoes anewitem = (Shoes)it.next();
            items.put("id", anewitem.getId());
            items.put("name", anewitem.getName());
            items.put("price", anewitem.getPrice());
            items.put("stock", anewitem.getStock());
            t.put("Shoes"+i, items);
        }
        return t;
    }
}

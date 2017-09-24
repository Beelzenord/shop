/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Niklas
 */

public class LookShirt {

    public LookShirt() {
    }
    
    public Hashtable getShirtWithGroup(String s) {
        Collection c = Shirt.searchItems(s);
        Hashtable t = new Hashtable();
        t.put("size", c.size());
        Iterator it = c.iterator();
        for (int i = 0; it.hasNext(); i++) {
            Hashtable items = new Hashtable();
            Shirt anewitem = (Shirt)it.next();
            items.put("name", anewitem.getItemName());
            items.put("brand", anewitem.getBrand());
            items.put("price", anewitem.getPrice());
            items.put("rating", anewitem.getRating());
            items.put("stock", anewitem.getStock());
            t.put("Shirt"+i, items);
        }
        return t;
    }
}
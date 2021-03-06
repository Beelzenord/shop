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
public class LookItems {

    public LookItems() {
    }
    
    public Hashtable getItemsWithGroup(String group, Connection con) {
        Collection c = null; //Item.searchItems(group, con);
        Hashtable t = new Hashtable();
        t.put("size", c.size());
        Iterator it = c.iterator();
        for (int i = 0; it.hasNext(); i++) {
            Hashtable items = new Hashtable();
            Item anewitem = (Item)it.next();
            items.put("name", anewitem.getName());
            items.put("price", anewitem.getPrice());
            items.put("stock", anewitem.getStock());
            t.put("Item"+i, items);
        }
        return t;
    }
    
}

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
public class LookOrders {

    public LookOrders() {
    }
    
    /**
     * Gets orders from the database to a Hashtable containing all order and
     * which instructions the orders should execute. 
     */
    public Hashtable getOrdersWithGroup(String group, Connection con) {
        Collection c = Orders.searchItems(group, con);
        Hashtable q = new Hashtable();
        Hashtable t = new Hashtable();
        Iterator it = c.iterator();
        int lastOrderID = -1, i;
        for (i = 0; it.hasNext(); i++) {
            Orders anewitem = (Orders)it.next();
            if (i == 0) {
                lastOrderID = anewitem.getOrderID();
            }
                
            Hashtable items = new Hashtable();
            items.put("orderID", anewitem.getOrderID());
            items.put("id", anewitem.getId());
            items.put("tableName", anewitem.getTableName());
            items.put("amount", anewitem.getAmount());
            items.put("username", anewitem.getUsername());
            
            if (lastOrderID == anewitem.getOrderID()) {
                t.put("Order"+i, items);
            }
            else {
                q.put(lastOrderID, t);
                t = new Hashtable();
                t.put("Order"+i, items);
                lastOrderID = anewitem.getOrderID();
            }
        }
        q.put(lastOrderID, t);
        return q;
    }
}

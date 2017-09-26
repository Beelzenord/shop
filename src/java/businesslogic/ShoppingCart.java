/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.Hashtable;

/**
 *
 * @author fauzianordlund
 */
public class ShoppingCart {
    private Hashtable cart;
    public ShoppingCart() {
        cart = new Hashtable();
    }
    // id, name, price, amount
    public void addNewElement(String type, int id, String name, float price, int amount) {
        Hashtable tmp = new Hashtable();
        tmp.put("id", id);
        tmp.put("name", name);
        tmp.put("price", price);
        tmp.put("amount", amount);
        cart.put(type, tmp);
    }

    public Hashtable getCart() {
        return cart;
    }
    
}

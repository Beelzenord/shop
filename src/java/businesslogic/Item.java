/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Niklas
 */
public class Item {
    private int id;
    private String name;
    private int price;
    static public Collection searchItems(String group) {
        Vector v = new Vector();
        /** Adding dummy items instead of calling database **/
        v.addElement(new Item(4, "thefirstitem", 8));
        v.addElement(new Item(9, "seconditem", 7));
        return v;
    }
    
    protected Item(int id , String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

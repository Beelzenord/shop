/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import Database.CreateOrderDB;
import datalayer.ValidateUser;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fauzianordlund
 */
public class Facade {
    private static User user;
    private ShoppingCart cart;
    private Hashtable shoes;
    private Hashtable pants;
    private Hashtable shirts;
    private Hashtable gloves;

    public Facade() {
        this.cart = new ShoppingCart();
    }
    
    public void updateShoppingCart(String target, int amount) {
        if (target.contains("Shoes")) {
            Hashtable tmp = (Hashtable)shoes.get(target);
            cart.addNewElement(target, (int)tmp.get("id"), (String)tmp.get("name"), (float)tmp.get("price"), amount);
        }
        else if (target.contains("Shirt")) {
            Hashtable tmp = (Hashtable)shirts.get(target);
            cart.addNewElement(target, (int)tmp.get("id"), (String)tmp.get("name"), (float)tmp.get("price"), amount);
        }
        else if (target.contains("Gloves")) {
            Hashtable tmp = (Hashtable)gloves.get(target);
            cart.addNewElement(target, (int)tmp.get("id"), (String)tmp.get("name"), (float)tmp.get("price"), amount);
        }
        else if (target.contains("Pants")) {
            Hashtable tmp = (Hashtable)pants.get(target);
            cart.addNewElement(target, (int)tmp.get("id"), (String)tmp.get("name"), (float)tmp.get("price"), amount);
        }
    }
    
    public void removeFromShoppingCart(String target) {
        cart.removeElement(target);
    }
    
    public static String example(){
       return "this will connect to a database";
    }
    public static Connection isValid(Connection con){
        //con = null;
        return con;
    }

    public Hashtable getCart() {
        return cart.getCart();
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    
    public static Hashtable getItems(String group, Connection con) {
        LookItems look = new LookItems();
        Hashtable table = look.getItemsWithGroup(group, con);
        System.out.println("table: " + table.toString());
        return table;
    }
    
    public Hashtable getShoes(String group, Connection con) {
        LookShoes look = new LookShoes();
        Hashtable table = look.getShoesWithGroup(group, con);
        this.shoes = table;
        return table;
    }
    
    public Hashtable getShirts(String group, Connection con) {
        LookShirts look = new LookShirts();
        Hashtable table = look.getShirtWithGroup(group, con);
        this.shirts = table;
        return table;
    }
        
    public Hashtable getGloves(String group, Connection con) {
        LookGloves look = new LookGloves();
        Hashtable table = look.getGlovesWithGroup(group, con);
        this.gloves = table;
        return table;
    }
        
    public Hashtable getPants(String group, Connection con) {
        LookPants look = new LookPants();
        Hashtable table = look.getPantsWithGroup(group, con);
        this.pants = table;
        return table;
    }
    
    public void createOrder() {
        CreateOrderDB.createOrder(user.getCon(), cart.getCart(), user.getUsername());
        // uppdate shoppingcart if successful
        cart = new ShoppingCart();
    }
    
    public static void getUserCredentials(String username,String password){
        User u = null;
        u = ValidateUser.validateClient(username, password);
        user = u;
        //return u;
    }
    
    public static User getUser() {
        return user;
    }
}
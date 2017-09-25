/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
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
    
    
    public static String example(){
       return "this will connect to a database";
    }
    public static Connection isValid(Connection con){
        
        //con = null;
        return con;
       
    }

    public ShoppingCart getCart() {
        return cart;
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
    
    public static Hashtable getShoes(String group, Connection con) {
        LookShoes look = new LookShoes();
        Hashtable table = look.getShoesWithGroup(group, con);
        System.out.println("table: " + table.toString());
        return table;
    }
    
    public static Hashtable getShirts(String group, Connection con) {
        LookShirts look = new LookShirts();
        Hashtable table = look.getShirtWithGroup(group, con);
        System.out.println("table: " + table.toString());
        return table;
    }
        
    public static Hashtable getGloves(String group, Connection con) {
        LookGloves look = new LookGloves();
        Hashtable table = look.getGlovesWithGroup(group, con);
        System.out.println("table: " + table.toString());
        return table;
    }
        
    public static Hashtable getPants(String group, Connection con) {
        LookPants look = new LookPants();
        Hashtable table = look.getPantsWithGroup(group, con);
        System.out.println("table: " + table.toString());
        return table;
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
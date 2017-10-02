/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import Database.HandleOrdersDB;
import Database.PresentListDB;
import Database.UpdateGoodsDB;
import Database.ConnectionDB;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The Facade handles logic between the view and the database, also logic within the session ex. updating the shopping cart
 * @author fauzianordlund
 */
public class Facade {
    private static User user;
    private static Admin admin;
    private static Stockstaff stockstaff;
    private ConnectionDB dbcon;
    private ShoppingCart cart;
    private Hashtable shoes;
    private Hashtable pants;
    private Hashtable shirts;
    private Hashtable gloves;
    private Hashtable orders;
    private Vector users;

    public Facade() {
        this.cart = new ShoppingCart();
        this.dbcon = new ConnectionDB();
    }
    
    /**
     * Puts an item into the shopping cart, 
     * @param target the type of item, shoes, shirts etc.
     * @param amount the amount of items to buy
     */
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
    public Vector getUsers(){
       users = PresentListDB.createOrder(dbcon.getCon());
       return users;
    } 
    public void removeFromShoppingCart(String target) {
        cart.removeElement(target);
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
    
    public Hashtable getItems(String group) {
        LookItems look = new LookItems();
        Hashtable table = look.getItemsWithGroup(group, dbcon.getCon());
        System.out.println("table: " + table.toString());
        return table;
    }
    
    public Hashtable getShoes(String group) {
        LookShoes look = new LookShoes();
        Hashtable table = look.getShoesWithGroup(group, dbcon.getCon());
        this.shoes = table;
        return table;
    }
    
    public Hashtable getShirts(String group) {
        LookShirts look = new LookShirts();
        Hashtable table = look.getShirtWithGroup(group, dbcon.getCon());
        this.shirts = table;
        return table;
    }
        
    public Hashtable getGloves(String group) {
        LookGloves look = new LookGloves();
        Hashtable table = look.getGlovesWithGroup(group, dbcon.getCon());
        this.gloves = table;
        return table;
    }
        
    public Hashtable getPants(String group) {
        LookPants look = new LookPants();
        Hashtable table = look.getPantsWithGroup(group, dbcon.getCon());
        this.pants = table;
        return table;
    }
    
    public Hashtable getOrders(String group) {
        LookOrders look = new LookOrders();
        System.out.println("test");
        Hashtable table = look.getOrdersWithGroup(group, dbcon.getCon());
        this.orders = table;
        return table;
    }
    
    /**
     * User sends an order to the database to be executed by staff
     */
    public void createOrder() {
        if (HandleOrdersDB.createOrder(dbcon.getCon(), cart.getCart(), user.getUsername()))
            cart = new ShoppingCart();
    }
    
    /**
     * A Stockstaff executes an order made by a user. This will update item tuples in the database and
     * remove the order executed from the database. 
     * @param orderID 
     */
    public void executeOrder(int orderID) {
        Hashtable tmp = (Hashtable)orders.get(orderID);
        HandleOrdersDB.executeOrder(dbcon.getCon(), tmp, orderID);
    }
    
    /**
     * Check if a user exists in the database and retrieves a Connection with said users privileges 
     */
    public void getUserCredentials(String username,String password){
        User u = null;
        u = dbcon.validateClient(username, password);
        user = u;
    }
    
    /**
     * Check if an admin exists in the database and retrieves a Connection with said admins privileges 
     */
    public void getAdminCredentials(String username,String password){
        Admin a = null;
        a = dbcon.validateAdmin(username, password);
        admin = a;
    }
    
    /**
     * Check if a stockstaff exists in the database and retrieves a Connection with said stockstaffs privileges 
     */
    public void getStockstaffCredentials(String username,String password){
        Stockstaff s = null;
        s = dbcon.validateStockstaff(username, password);
        stockstaff = s;
    }
    
    public static User getUser() {
        return user;
    }
    
    public static Admin getAdmin(){
        return admin;
    }
        
    public static Stockstaff getStockstaff(){
        return stockstaff;
    }    
    
    /**
     * Updates a user in the database, ex. username, password email
     */
    public void  updateUser(String username, User u){
        dbcon.updateTheUser(username,u);
    }
    
    /**
     * Updates tuples of items in the database, ex. name, price
     */
    public void updateGoodsInDatabase(int id, String tableName, String name, float price, int stock) {
        UpdateGoodsDB.updateGoods(dbcon.getCon(), id, tableName, name, price, stock);
    }
    
    /**
     * Inserts new goods in the database, ex. new shoes, shirt
     */
    public void insertGoodsInDatabase(String tableName, String name, float price, int stock) {
        UpdateGoodsDB.insertGoods(dbcon.getCon(), tableName, name, price, stock);
    }
   
}

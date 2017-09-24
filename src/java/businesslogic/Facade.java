/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import datalayer.ValidateUser;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Hashtable;


/**
 *
 * @author fauzianordlund
 */
public class Facade {
    public static String example(){
       return "this will connect to a database";
    }
    public static Connection isValid(Connection con, String user, String pass){
        
        con = ValidateUser.Connect(con, user, pass);
        return con;
       
      
    }
    
    public static Hashtable getItems() {
        LookItems look = new LookItems();
        Hashtable table = look.getItemsWithGroup("hej");
        System.out.println("table: " + table.toString());
        for (int i = 0; i < (int)table.get("size"); i++) {
            Hashtable tmp = (Hashtable)table.get("Item"+i);
            System.out.println("name: " + tmp.get("itemName"));
            System.out.println("price: " + tmp.get("price"));
        }
        return table;
    }
    
    public static Hashtable getShoes(Connection con) {
        LookShoes look = new LookShoes();
        Hashtable table = look.getShoesWithGroup("hej", con);
        System.out.println("table: " + table.toString());
        for (int i = 0; i < (int)table.get("size"); i++) {
            Hashtable tmp = (Hashtable)table.get("Shoes"+i);
            System.out.println("name: " + tmp.get("name"));
            System.out.println("price: " + tmp.get("price"));
        }
        return table;
    }
}
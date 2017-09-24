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
    public static String example(){
       return "this will connect to a database";
    }
    private static Connection isValid(Connection con){
        
        //con = null;
        return con;
       
    }
    
    public static Hashtable getItems() {
        LookItems look = new LookItems();
        Hashtable table = look.getItemsWithGroup("hej");
        System.out.println("table: " + table.toString());
        for (int i = 0; i < (int)table.get("size"); i++) {
            Hashtable tmp = (Hashtable)table.get("Item"+i);
            System.out.println("name: " + tmp.get("name"));
            System.out.println("price: " + tmp.get("price"));
        }
        return table;
    }
    public static User getUserCredentials(String username,String password){
      User u = null;
      u = ValidateUser.validateClient(username, password);
       return u;
    }
}
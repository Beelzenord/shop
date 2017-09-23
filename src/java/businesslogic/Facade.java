/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import datalayer.ValidateUser;
import static java.lang.System.out;
import java.sql.Connection;


/**
 *
 * @author fauzianordlund
 */
public class Facade {
    public static String example(){
       return "this will connect to a database";
    }
    public static Connection isValid(Connection con){
        
        con = ValidateUser.Connect(con);
        return con;
       
      
    }
}
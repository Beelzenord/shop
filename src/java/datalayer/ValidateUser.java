/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author fauzianordlund
 */
public class ValidateUser {
  
    public static Connection Connect(Connection con, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false", user, pass);
            System.out.println("Connection granted");
            return con;
        }
     catch (SQLException ex) {
                Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
      catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
               return null;
      }    
    }
    public static boolean validationOfConnection(Connection con){
        if(con!=null){
            return true;
        }
        else{
            return false;
        }
    }
}

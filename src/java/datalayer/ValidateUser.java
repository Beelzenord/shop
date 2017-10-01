/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;
import businesslogic.Admin;
import businesslogic.Facade;
import businesslogic.Stockstaff;
import businesslogic.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
  
    private static Connection Connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false", "root", "root");
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
    public static User validateClient(String username, String password){
        User u=null;
        PreparedStatement ps=null;
        Connection con = null;
        ResultSet rs = null;
        String user = null;
        String pass = null;
   	String fname = null;
    	String lname = null; 
    	String email = null;
        int id = 0;
        try {
             Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost/shop?autoReconnect=true&useSSL=false",username,password);
 
            ps = con.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){ 		// id                    username             pass                     fn                       ln                      
    		id = rs.getInt(1); user = rs.getString(2);pass = rs.getString(3);fname= rs.getString(4); lname= rs.getString(5);email = rs.getString(6);
    		System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));	
    	    }
            u = new User(id,user,pass,fname,lname,email); 
            u.setCon(con);
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
            //con.close();
            return null;
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
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
    public static Admin validateAdmin(String username, String password){
        Admin a=null;
        PreparedStatement ps=null;
        Connection con = null;
        ResultSet rs = null;
        String user = null;
        String pass = null;
   	String fname = null;
    	String lname = null; 
    	String email = null;
        int id = 0;
        try {
             Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/shop?autoReconnect=true&useSSL=false","root","root");
 
            ps = con.prepareStatement("select * from admin where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){ 		// id                    username             pass                     fn                       ln                      
    		id = rs.getInt(1); user = rs.getString(2);pass = rs.getString(3);fname= rs.getString(4); lname= rs.getString(5);email = rs.getString(6);
    		System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));	
    	    }
            a = new Admin(id,user,pass,fname,lname,email); 
            a.setCon(con);
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
            //con.close();
            return null;
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return null;    
        }
    }
    
    public static Stockstaff validateStockstaff(String username, String password){
        Stockstaff a=null;
        PreparedStatement ps=null;
        Connection con = null;
        ResultSet rs = null;
        String user = null;
        String pass = null;
   	String fname = null;
    	String lname = null; 
    	String email = null;
        int id = 0;
        try {
             Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/shop?autoReconnect=true&useSSL=false","root","root");
 
            ps = con.prepareStatement("select * from stockstaff where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){ 		// id                    username             pass                     fn                       ln                      
    		id = rs.getInt(1); user = rs.getString(2);pass = rs.getString(3);fname= rs.getString(4); lname= rs.getString(5);email = rs.getString(6);
    		System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));	
    	    }
            a = new Stockstaff(id,user,pass,fname,lname,email); 
            a.setCon(con);
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
            //con.close();
            return null;
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
            return null;    
        }
        
    }
    public static void updateTheUser(Connection con, User u){
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = con.prepareStatement("update user set username = ?,password = ?,firstName = ?, lastName = ?, email = ? where id = ?");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFirstName());
            ps.setString(4, u.getLastName());
            ps.setString(5, u.getEmail());
            ps.setInt(6, u.getId());
            ps.executeUpdate();
        }
        catch(Exception ex){
           ex.printStackTrace();
        }
        
        
    }
    public static void issueGrant(User u , Connection con){
       // CREATE USER IF NOT EXISTS 'u1'@'localhost' identified BY 'u1';
       //GRANT SELECT, INSERT, UPDATE ON shoeClass TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE ON shirtClass TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE ON glovesClass TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE ON pantsClass TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE ON user TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE, DELETE ON orders TO 'u1'@'localhost';
       //GRANT SELECT, INSERT, UPDATE ON orderDetails TO 'u1'@'localhost';
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
    PreparedStatement ps5 = null;
    PreparedStatement ps6 = null;
    PreparedStatement ps7 = null;
    PreparedStatement ps8 = null;
    ResultSet rs = null;
   
     try {  
         ps1 = con.prepareStatement("CREATE USER IF NOT EXISTS ? @'localhost' identified BY ? ");
         ps2 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON shoeClass TO ?@'localhost' ");
         ps3 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON shirtClass TO ?@'localhost' ");
         ps4 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON glovesClass TO ?@'localhost' ");
         ps5 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON pantsClass TO ?@'localhost' ");
         ps6 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON user TO ?@'localhost' ");
         ps7 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE, DELETE ON orders TO ?@'localhost' ");
         ps8 = con.prepareStatement("GRANT SELECT, INSERT, UPDATE ON orderDetails TO '?'@'localhost' ");
         ps1.setString(1, u.getUsername());
         ps1.setString(2, u.getUsername());
         ps2.setString(1, u.getUsername());
         ps3.setString(1, u.getUsername());
         ps4.setString(1, u.getUsername());
         ps5.setString(1, u.getUsername());
         ps6.setString(1, u.getUsername());
         ps7.setString(1, u.getUsername());
         ps8.setString(1, u.getUsername());
         ps1.execute();
         ps2.execute();
         ps3.execute();
         ps4.execute();
         ps5.execute();
         ps6.execute();
         ps7.execute();
         ps8.execute();
        
     } catch (SQLException ex) {
                Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    }
    public static String returnUserName(Connection con, String username){
        PreparedStatement ps= null;
        ResultSet rs = null;
        String proof=null;
         try {
            
            ps = con.prepareStatement("select User from mysql.user where user = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){ 		// id                    username             pass                     fn                       ln                      
    		proof = rs.getString("User");
            }
            return proof;
            /*
            
            if(username.equals(proof)){
                return "checked";
            }
            else{
                return "false";
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(ValidateUser.class.getName()).log(Level.SEVERE, null, ex);
            //con.close();
            return null;
        }
      
    }
    
}

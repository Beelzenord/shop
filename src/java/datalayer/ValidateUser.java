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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import businesslogic.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author fauzianordlund
 */
public class PresentListDB {
     private static String createStatement() {
        return "select * from user";
    }
    public static Vector createOrder(Connection con){
        Statement stmt = null;
        ResultSet rs = null;
       // List<User> the_users = new ArrayList<>();
      // Hashtable the_users = new Hastable;
        Vector vector = new Vector();
    //   Hashtable<Integer,User> hm=new Hashtable<Integer,User>();  
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(createStatement());
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fn    = rs.getString("firstName");
                String ln    = rs.getString("lastName");
                String email = rs.getString("email");
                User temp = new User(id,username,password,fn,ln,email);
               // hm.put(id, temp);
                vector.add(temp);
            }
            return vector;
        }catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}

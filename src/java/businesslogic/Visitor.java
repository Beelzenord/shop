/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.sql.Connection;

/**
 *
 * @author fauzianordlund
 */
public class Visitor {
      private String username;
      private String password;
      private Connection con;
      public Visitor(String user, String pass){
         this.username = user;
          this.password = pass;
      }
       public void initConection(){
        
      }
       public void validateClient(){
          
       }
}

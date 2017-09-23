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
public class User {
      private String username;
    private String password;
    private Connection con;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public void initConection(){
        this.con = Facade.isValid(con);
    }
    public boolean isUserConnected(){
        if(this.con!=null){
            return true;
        }
        else{
            return false;
        }
    }
}

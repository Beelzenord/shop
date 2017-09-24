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
    int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Connection con;
    public User(){
        
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    /*  public void initConection(){
        this.con = Facade.isValid(con);
    }*/
    public boolean isUserConnected(){
        if(this.con!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", con=" + con + '}';
    }
    
}

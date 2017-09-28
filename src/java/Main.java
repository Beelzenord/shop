/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import businesslogic.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Niklas
 */
public class Main {
    public static void main(String[] args) {
       Facade facade = new Facade();
       facade.getUserCredentials("u1", "u1");
       /*facade.getShoes("hej", facade.getUser().getCon());
       facade.updateShoppingCart("Shoes0", 5);
       facade.createOrder();*/
       Hashtable t = facade.getOrders("hej", facade.getUser().getCon());
       Enumeration e = t.keys();
       int i = (int)e.nextElement();
       System.out.println("i: " + i);
       
       
       
       
    }
}

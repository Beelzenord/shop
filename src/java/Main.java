/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import businesslogic.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Niklas
 */
public class Main {
    public static void main(String[] args) {
        Facade logic = new Facade();
        logic.getItems();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businesslogic.Admin;
import businesslogic.Facade;
import businesslogic.Stockstaff;
import businesslogic.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fauzianordlund
 */
public class ControllerApplication extends HttpServlet {
      //Facade facade;
      //User u ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null; 

        if (request.getParameter("actionType") == null) {
            rd = request.getRequestDispatcher("LoginPage.jsp");
            rd.forward(request, response);
        }
        
        Facade facade = null;
        if (request.getSession().getAttribute("Facade") != null)
            facade = (Facade)request.getSession().getAttribute("Facade");
            
        String actionType = (String)request.getParameter("actionType");
        switch(actionType) {

            case("SearchItems"):
                HttpSession session = request.getSession();
                if (request.getParameter("Shoes") != null) 
                    session.setAttribute("searchShoes", "Yes");
                else
                    session.setAttribute("searchShoes", null);

                if (request.getParameter("Shirts") != null) 
                    session.setAttribute("searchShirts", "Yes");
                else
                    session.setAttribute("searchShirts", null);

                if (request.getParameter("Gloves") != null) 
                    session.setAttribute("searchGloves", "Yes");
                else
                    session.setAttribute("searchGloves", null);

                if (request.getParameter("Pants") != null) 
                    session.setAttribute("searchPants", "Yes");
                else
                    session.setAttribute("searchPants", null);
                response.sendRedirect("ShowTable.jsp");
                /*rd = request.getRequestDispatcher("ShowTable.jsp");
                rd.forward(request, response);*/
                break;

            case("UpdateShoppingcart"):
                String target = (String)request.getParameter("Item");
                int amount = Integer.parseInt(request.getParameter("Amount"));
                facade = (Facade)request.getSession().getAttribute("Facade");
                facade.updateShoppingCart(target, amount);
                rd = request.getRequestDispatcher("ShowTable.jsp");
                rd.forward(request, response);
                break;

            case("CreateOrder"):
                facade = (Facade)request.getSession().getAttribute("Facade");
                facade.createOrder();
                rd = request.getRequestDispatcher("showshoppingcart.jsp");
                rd.forward(request, response);
                break;

            case("RemoveFromCart"):
                String target1 = (String)request.getParameter("Removed");
                facade = (Facade)request.getSession().getAttribute("Facade");
                facade.removeFromShoppingCart(target1);
                rd = request.getRequestDispatcher("showshoppingcart.jsp");
                rd.forward(request, response);
                break;

            case("ExecuteOrder"):
                int orderID = Integer.parseInt(request.getParameter("Execute"));
                facade = (Facade)request.getSession().getAttribute("Facade");
                facade.executeOrder(orderID);
                rd = request.getRequestDispatcher("ShowOrders.jsp");
                rd.forward(request, response);
                break;

            case("UpdateGoodsInDatabase"):
                facade = (Facade)request.getSession().getAttribute("Facade"); 
                int id = Integer.parseInt(request.getParameter("ID"));
                String tableName = (String)request.getParameter("tableName");
                String name = (String)request.getParameter("name");
                float price = Float.parseFloat(request.getParameter("price"));
                int stock = Integer.parseInt(request.getParameter("stock"));

                String action = (String)request.getParameter("action");
                if (action.equals("update")) 
                    facade.updateGoodsInDatabase(id, tableName, name, price, stock);
                else
                    facade.insertGoodsInDatabase(tableName, name, price, stock);
                rd = request.getRequestDispatcher("EditGoodsInDatabase.jsp");
                rd.forward(request, response);
                break;

            default:
                rd = request.getRequestDispatcher("LoginPage.jsp");
                rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("usertype") != null)
            processLogin(request,response);
    }
    
    protected void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        Facade facade = new Facade();
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        switch(usertype){
            case "client": 
                facade.getUserCredentials(username, password);
                User u = facade.getUser();
                session.setAttribute("Facade", facade); // store facade in sessions
                rd = request.getRequestDispatcher("mainservices.jsp");
                if(username.equals(u.getUsername())&&password.equals(u.getPassword())){
                    rd.forward(request, response);
                }    
                else{
                    out.println("invalid");
                }
                break;
                
            case "admin":  
                out.println("admin"); 
                facade.getAdminCredentials(username, password); 
                Admin a = facade.getAdmin();              
                session.setAttribute("Facade", facade); // store facade in sessions
                rd = request.getRequestDispatcher("adminservices.jsp");
                if(username.equals(a.getUsername())&&password.equals(a.getPassword())){
                    rd.forward(request, response);
                }    
                break;
                           
            case "stockstaff":  
                facade.getStockstaffCredentials(username, password); 
                Stockstaff s = facade.getStockstaff();              
                session.setAttribute("Facade", facade); // store facade in sessions
                rd = request.getRequestDispatcher("StockstaffServices.jsp");
                if(username.equals(s.getUsername())&&password.equals(s.getPassword())){
                    rd.forward(request, response);
                }    
                break;
                
            default: 
                rd = request.getRequestDispatcher("LoginPage.jsp");
                rd.forward(request, response);
        }
    }
    protected void doEdit(HttpServletRequest request, HttpServletResponse response){
        int id  = Integer.parseInt(request.getParameter("ID"));
        int    marker   = Integer.parseInt(request.getParameter("marker"));
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");                   
        String lastName = request.getParameter("lastName");
        String email    = request.getParameter("email");
        Facade fc = (Facade) session.getAttribute("Facade"); 
        Admin a = fc.getAdmin();                 
        User preUpdate = new User(id,username,password,firstName,lastName,email);
        fc.updateUser(a.getCon(), preUpdate);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   
}

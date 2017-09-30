/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businesslogic.Facade;
import businesslogic.Stockstaff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fauzianordlund
 */
public class ControllerApplication extends HttpServlet {

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
            case("ConfirmAdmin"):
                
            case("Confirm"):
                
            case("ConfirmStockstaff"):
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                facade = new Facade(); // new shopping cart
                facade.getStockstaffCredentials(username, password);  
                Stockstaff a = facade.getStockstaff();
                request.getSession().setAttribute("Facade", facade); // store facade in sessions
                if(username.equals(a.getUsername())&&password.equals(a.getPassword())){
                  rd = request.getRequestDispatcher("StockStaffServices.jsp");
                  rd.forward(request, response);
                }    
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
            default:
                
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
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        out.println(username + " " + password + " "+ usertype);
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

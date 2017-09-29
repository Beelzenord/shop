<%-- 
    Document   : ConfirmStockstaff
    Created on : Sep 28, 2017, 3:20:20 PM
    Author     : Niklas
--%>

<%@page import="businesslogic.Stockstaff"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%
            RequestDispatcher ds = request.getRequestDispatcher("StockStaffServices.jsp"); 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Facade facade = new Facade(); // new shopping cart
            facade.getStockstaffCredentials(username, password);  
            Stockstaff a = facade.getStockstaff();
            session.setAttribute("Facade", facade); // store facade in sessions
            if(username.equals(a.getUsername())&&password.equals(a.getPassword())){
              ds.forward(request, response);
            }    
        %>
    </body>
</html>

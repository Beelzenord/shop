<%-- 
    Document   : confirmadmin
    Created on : Sep 26, 2017, 10:44:48 PM
    Author     : fauzianordlund
--%>

<%@page import="businesslogic.Admin"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%
            RequestDispatcher ds = request.getRequestDispatcher("adminservices.jsp"); 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Facade facade = new Facade(); // new shopping cart
            facade.getAdminCredentials(username, password);  
            Admin a = facade.getAdmin();
            session.setAttribute("Facade", facade); // store facade in sessions
            if(username.equals(a.getUsername())&&password.equals(a.getPassword())){
              ds.forward(request, response);
            }    
        %>
    </body>
</html>

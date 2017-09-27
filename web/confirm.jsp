<%-- 
    Document   : confirm
    Created on : Sep 24, 2017, 2:54:57 AM
    Author     : fauzianordlund
--%>

<%@page import="businesslogic.User"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
     <%
            RequestDispatcher ds = request.getRequestDispatcher("mainservices.jsp"); 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Facade facade = new Facade(); // new shopping cart
            facade.getUserCredentials(username, password);  
            User u = facade.getUser();
            session.setAttribute("Facade", facade); // store facade in sessions
            if(username.equals(u.getUsername())&&password.equals(u.getPassword())){
              ds.forward(request, response);
            }    
            else{
                out.println("invalid");
            }
            
        %>
       
    </body>
</html>

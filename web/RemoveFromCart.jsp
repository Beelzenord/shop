<%-- 
    Document   : RemoveFromCart
    Created on : Sep 26, 2017, 3:09:40 PM
    Author     : Niklas
--%>

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
            String target = (String)request.getParameter("Removed");
            Facade facade = (Facade)session.getAttribute("Facade");
            facade.removeFromShoppingCart(target);
            String site = new String("showshoppingcart.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site); 
        %>
    </body>
</html>

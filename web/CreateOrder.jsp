<%-- 
    Document   : SendOrder
    Created on : Sep 26, 2017, 9:32:44 PM
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
            Facade facade = (Facade)session.getAttribute("Facade");
            facade.createOrder();
            
            String site = new String("showshoppingcart.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        %>
    </body>
</html>

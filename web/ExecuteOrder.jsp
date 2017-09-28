<%-- 
    Document   : ExecuteOrder
    Created on : Sep 27, 2017, 11:28:56 PM
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
            int orderID = Integer.parseInt(request.getParameter("Execute"));
            Facade facade = (Facade)session.getAttribute("Facade");
            facade.executeOrder(orderID);
            String site = new String("ShowOrders.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site); 
        %>
    </body>
</html>

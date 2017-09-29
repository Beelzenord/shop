<%-- 
    Document   : UpdateGoodsInDatabase
    Created on : Sep 29, 2017, 10:58:29 PM
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
            
            String site = new String("EditGoodsInDatabase.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        %>
    </body>
</html>

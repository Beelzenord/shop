<%-- 
    Document   : shoppingcart
    Created on : Sep 25, 2017, 3:25:52 PM
    Author     : fauzianordlund
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String s = (String)request.getParameter("Item");
            int amount = Integer.parseInt(request.getParameter("Amount"));
            out.println(s + " ");
            out.println(amount);
            String site = new String("ShowTable.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site); 
            request.getParameter("Shoes");
            request.getParameter("Gloves");
            request.getParameter("Pants");
            request.getParameter("Shirts");
       %>
    </body>
</html>

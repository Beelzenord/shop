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
            String s = (String)request.getParameter("Pants");
            int amount = Integer.parseInt(request.getParameter("Amount"));
            out.println(s + " ");
            out.println(amount);
            //int number = (int)request.getAttribute("Pants1");
            //out.println(number);
        %>
    </body>
</html>

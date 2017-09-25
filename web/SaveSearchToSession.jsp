<%-- 
    Document   : SaveSearchToSession
    Created on : Sep 25, 2017, 11:52:47 PM
    Author     : Niklas
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
            if (request.getParameter("Shoes") != null) 
                session.setAttribute("searchShoes", "Yes");
            else
                session.setAttribute("searchShoes", null);
            
            if (request.getParameter("Shirts") != null) 
                session.setAttribute("searchShirts", "Yes");
            else
                session.setAttribute("searchShirts", null);
            
            if (request.getParameter("Gloves") != null) 
                session.setAttribute("searchGloves", "Yes");
            else
                session.setAttribute("searchGloves", null);
            
            if (request.getParameter("Pants") != null) 
                session.setAttribute("searchPants", "Yes");
            else
                session.setAttribute("searchPants", null);
            
            String site = new String("ShowTable.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site); 
        %>
    </body>
</html>

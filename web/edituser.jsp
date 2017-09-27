<%-- 
    Document   : edituser
    Created on : Sep 27, 2017, 1:34:29 AM
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
        <h1>User Profiles</h1>
        <% Facade facade = (Facade)session.getAttribute("Facade");
           Admin a = facade.getAdmin();
           
        %>
    </body>
</html>

<%-- 
    Document   : loginvalidation.jsp
    Created on : Sep 23, 2017, 3:48:41 PM
    Author     : fauzianordlund
--%>

<%@page import="businesslogic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Validation</title>
    </head>
    <body>
        <%
                 String user=request.getParameter("username");
                 String pass=request.getParameter("password");
                 out.println(user);
                 out.println(pass);
                 User u = new User(user,pass);
                 out.println("here is " + u.getUsername());
                 
                 u.initConection();
                 out.println(u.isUserConnected());
            %>
    </body>
</html>

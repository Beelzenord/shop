<%-- 
    Document   : LoginPage
    Created on : Sep 22, 2017, 11:05:05 AM
    Author     : fauzianordlund
    <a href = "loginadmin.jsp">Login as staff</a>
--%>

<%@page import="javafx.application.Platform"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        
                             
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The login page</title>
    </head>
    <body>                                 
        <h1>Welcome to the E-Shop</h1>
          <form  method ="post" action="ControllerApplication" scope ="session">
            Enter the word: <input type="text" name="username" required><br/>
            Enter the password: <input type = "password" name="password" required><br/>
            <input type="hidden" name ="usertype" value = "client">
            <input type="submit" value = "OK">
          </form>
        <a href = "loginadmin.jsp">Login as admin</a><br>
        <a href = "LoginStockstaff.jsp">Login as stock staff</a>
    </body>
</html>

        
        
        
        


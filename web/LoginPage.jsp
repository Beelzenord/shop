<%-- 
    Document   : LoginPage
    Created on : Sep 22, 2017, 11:05:05 AM
    Author     : fauzianordlund
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The login page</title>
    </head>
    <body>
        <h1>Welcome to the E-Shop</h1>
        <form action ="BusinessLogic" method = "get">
            Username : <input type ="text" name ="username"/><br/>
            Password : <input type = "password" name ="password"><br/>
            <input type ="submit" value = "OK">
    </body>
</html>

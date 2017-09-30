<%-- 
    Document   : LoginStockstaff
    Created on : Sep 28, 2017, 3:18:08 PM
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
        <h1>Login as Stockstaff</h1>
        <form method ="post" action ="ControllerApplication" scope = "session">
            <input type = "text" name ="username" require><br/>
            <input type = "password" name ="password" required><br/>
            <input type = "hidden" name ="stockstaff" value="yes">
            <input type = "hidden" name ="actionType" value ="ConfirmStockstaff">
            <input type = "submit" value ="Submit">
        </form>
      
    </body>
</html>

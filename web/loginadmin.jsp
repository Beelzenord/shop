<%-- 
    Document   : loginadmin
    Created on : Sep 26, 2017, 8:49:03 PM
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
        <h1>Login as admin</h1>
        <form name ="confirm.jsp" method = "get" scope = "session">
            <input type = "text" name ="username" require><br/>
            <input type = "password" name ="password" required><br/>
            <input type = "hidden" name ="admin" value="yes">
            <input type = "submit" value ="Submit">
        </form>
    </body>
</html>

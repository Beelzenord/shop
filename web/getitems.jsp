<%-- 
    Document   : test
    Created on : Sep 22, 2017, 1:23:39 PM
    Author     : Niklas
--%>

<%@page import="businesslogic.User"%>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businesslogic.Facade"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Checkmark the items you want to find </h2>
        <form method=get action="ShowTable.jsp">
        <input type="checkbox" name="Shoes" value="Yes">Shoes<br>
        <input type="checkbox" name="Shirt" value="Yes">Shirts<br>
        <br><br>
        <input type="submit" value="Search">
        </form>
    </body>
</html>

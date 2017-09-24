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
        <h1>H1 stuff</h1>
        <h2>contents</h2>
        
        <%
            String username = (String)session.getAttribute("Name");
            String pass = (String)session.getAttribute("Password");
            User newU = new User(username, pass);
            newU.initConection();
            
            Hashtable table = Facade.getShoes(newU.getCon());
        %>
        <table>
            <%
                for (int i = 0; i < (int)table.get("size"); i++) {
                    Hashtable tmp = (Hashtable)table.get("Shoes"+i);
            %>
            <tr>
            <td> name </td> <td> <%= tmp.get("name")%></td> 
            <td> brand </td> <td> <%= tmp.get("brand")%></td> 
            <td> price </td> <td> <%= tmp.get("price")%></td> 
            <td> rating </td> <td> <%= tmp.get("rating")%></td> 
            <td> stock </td> <td> <%= tmp.get("stock")%></td> 
            </tr>
            <% } %>
            
        </table>
        
    </body>
</html>
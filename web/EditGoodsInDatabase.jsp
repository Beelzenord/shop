<%-- 
    Document   : EditDatabase
    Created on : Sep 29, 2017, 10:22:20 PM
    Author     : Niklas
--%>

<%@page import="java.util.Hashtable"%>
<%@page import="businesslogic.Stockstaff"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit goods in the database</h1>
        <%
            Facade facade = (Facade)session.getAttribute("Facade");
            Stockstaff staff = facade.getStockstaff();
            Hashtable table = new Hashtable();
            for (int k = 0; k < 1; k++) {
                table = null;
                    table = facade.getShoes("hej", staff.getCon());%>
                    <h2>Shoes</h2>
                        <%
                            for (int i = 0; i < (int)table.get("size"); i++) {
                                Hashtable tmp = (Hashtable)table.get("Shoes"+i);
                        %>
                            <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                            Name   <input type = "text" name = "name" value ="<%= tmp.get("name") %>"required>
                            Price   <input type = "text" name = "price" value ="<%= tmp.get("price") %>"required>
                            Stock <input type = "text" name = "stock" value ="<%= tmp.get("stock") %>"required>
                            <input type="hidden" name = "tableName"  value = "shoeClass"> 
                            <input type="hidden" name ="ID" value="<%= tmp.get("id") %>">
                            <input type="hidden" name ="action" value="update">
                            <input type="submit" value ="Update">
                            </form><br>
                        <% } %>
                            <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                            Name   <input type = "text" name = "name" value =""required>
                            Price   <input type = "text" name = "price" value =""required>
                            Stock <input type = "text" name = "stock" value =""required>
                            <input type="hidden" name = "tableName"  value = "shoeClass"> 
                            <input type="hidden" name ="ID" value="-1">
                            <input type="hidden" name ="action" value="insert">
                            <input type="submit" value ="Create">
                            </form><br><br>
            <%            
                table = facade.getShirts("hej", staff.getCon()); %>
                <h2>Shirts</h2>
                    <%
                        for (int i = 0; i < (int)table.get("size"); i++) {
                            Hashtable tmp = (Hashtable)table.get("Shirt"+i);
                    %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value ="<%= tmp.get("name") %>"required>
                        Price   <input type = "text" name = "price" value ="<%= tmp.get("price") %>"required>
                        Stock <input type = "text" name = "stock" value ="<%= tmp.get("stock") %>"required>
                        <input type="hidden" name = "tableName"  value = "shirtClass"> 
                        <input type="hidden" name ="ID" value="<%= tmp.get("id") %>">
                        <input type="hidden" name ="action" value="update">
                        <input type="submit" value ="Update">
                        </form><br>
                    <% } %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value =""required>
                        Price   <input type = "text" name = "price" value =""required>
                        Stock <input type = "text" name = "stock" value =""required>
                        <input type="hidden" name = "tableName"  value = "shirtClass"> 
                        <input type="hidden" name ="ID" value="-1">
                        <input type="hidden" name ="action" value="insert">
                        <input type="submit" value ="Create">
                        </form><br><br>
                <%
                table = facade.getGloves("hej", staff.getCon()); %>
                <h2>Gloves</h2>
                    <%
                        for (int i = 0; i < (int)table.get("size"); i++) {
                            Hashtable tmp = (Hashtable)table.get("Gloves"+i);
                    %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value ="<%= tmp.get("name") %>"required>
                        Price   <input type = "text" name = "price" value ="<%= tmp.get("price") %>"required>
                        Stock <input type = "text" name = "stock" value ="<%= tmp.get("stock") %>"required>
                        <input type="hidden" name = "tableName"  value = "glovesClass"> 
                        <input type="hidden" name ="ID" value="<%= tmp.get("id") %>">
                        <input type="hidden" name ="action" value="update">
                        <input type="submit" value ="Update">
                        </form><br>
                    <% } %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value =""required>
                        Price   <input type = "text" name = "price" value =""required>
                        Stock <input type = "text" name = "stock" value =""required>
                        <input type="hidden" name = "tableName"  value = "glovesClass"> 
                        <input type="hidden" name ="ID" value="-1">
                        <input type="hidden" name ="action" value="insert">
                        <input type="submit" value ="Create">
                        </form><br><br>
                <%
                table = facade.getPants("hej", staff.getCon()); %>
                <h2>Pants</h2>
                    <%
                        for (int i = 0; i < (int)table.get("size"); i++) {
                            Hashtable tmp = (Hashtable)table.get("Pants"+i);
                    %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value ="<%= tmp.get("name") %>"required>
                        Price   <input type = "text" name = "price" value ="<%= tmp.get("price") %>"required>
                        Stock <input type = "text" name = "stock" value ="<%= tmp.get("stock") %>"required>
                        <input type="hidden" name = "tableName"  value = "pantsClass"> 
                        <input type="hidden" name ="ID" value="<%= tmp.get("id") %>">
                        <input type="hidden" name ="action" value="update">
                        <input type="submit" value ="Update">
                        </form><br>
                    <% } %>
                        <form method="get" action ="UpdateGoodsInDatabase.jsp" scope = "session">
                        Name   <input type = "text" name = "name" value =""required>
                        Price   <input type = "text" name = "price" value =""required>
                        Stock <input type = "text" name = "stock" value =""required>
                        <input type="hidden" name = "tableName"  value = "pantsClass"> 
                        <input type="hidden" name ="ID" value="-1">
                        <input type="hidden" name ="action" value="insert">
                        <input type="submit" value ="Create">
                        </form><br><br>
                <% } %>
    </body>
</html>

<%-- 
    Document   : ShowTable
    Created on : Sep 24, 2017, 10:32:20 PM
    Author     : Niklas
--%>

<%@page import="businesslogic.ShoppingCart"%>
<%@page import="java.util.Hashtable"%>
<%@page import="businesslogic.User"%>
<%@page import="businesslogic.Facade"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <a href= "showshoppingcart.jsp"> See Shopping Cart</a><br>
        <a href= "getitems.jsp"> Search for Items</a><br>
        <h1>Items for sale</h1>
        <%
            String username = (String)session.getAttribute("Name");
            String password = (String)session.getAttribute("Password");
            Facade facade = (Facade)session.getAttribute("Facade");
            
            //Facade facade = new Facade();
            //session.setAttribute("Facade", facade);
            //facade.getUserCredentials("u1", "u1");
            User u = facade.getUser();
            Hashtable table = new Hashtable();
            for (int k = 0; k < 4; k++) {
                table = null;
                if (session.getAttribute("searchShoes") != null && k == 0) { 
                    table = facade.getShoes("hej", u.getCon());%>
                    <h2>Shoes</h2>
                    <table>
                        <tr>
                            <th> Name </th>
                            <th> Price </th>
                            <th> Stock </th>
                        </tr>
                        <%
                            for (int i = 0; i < (int)table.get("size"); i++) {
                                Hashtable tmp = (Hashtable)table.get("Shoes"+i);
                        %>
                        <tr>
                            <td> <%= tmp.get("name")%></td> 
                            <td> <%= tmp.get("price")%></td> 
                            <td> <%= tmp.get("stock")%></td> 
                            <%String item = "Shoes"+i;%>
                            <td> 
                                <form method="get" action="shoppingcart.jsp">
                                <select name = "Amount"> 
                                    <% for(int z = 1;z <= (int)tmp.get("stock");z++){ %> 
                                        <option value = <%=z%>> <%= z %> </option>
                                    <% } %> 
                                </select>
                            </td> 
                                <input type="hidden" name="Item" value=<%=item%>>
                            <td> 
                                 <input type="submit" value="Add to Cart">
                                </form> 
                            </td>   
                        </tr>
                        <% } %>

                    </table>
                <%}
                if (session.getAttribute("searchShirts") != null && k == 1) { 
                    table = facade.getShirts("hej", u.getCon()); %>
                    <h2>Shirts</h2>
                                       <table>
                        <tr>
                            <th> Name </th>
                            <th> Price </th>
                            <th> Stock </th>
                        </tr>
                        <%
                            for (int i = 0; i < (int)table.get("size"); i++) {
                                Hashtable tmp = (Hashtable)table.get("Shirt"+i);
                        %>
                        <tr>
                            <td> <%= tmp.get("name")%></td> 
                            <td> <%= tmp.get("price")%></td> 
                            <td> <%= tmp.get("stock")%></td> 
                            <%String item = "Shirt"+i;%>
                            <td> 
                                <form method="get" action="shoppingcart.jsp">
                                <select name = "Amount"> 
                                    <% for(int z = 1;z <= (int)tmp.get("stock");z++){ %> 
                                        <option value = <%=z%>> <%= z %> </option>
                                    <% } %> 
                                </select>
                            </td> 
                                <input type="hidden" name="Item" value=<%=item%>>
                            <td> 
                                 <input type="submit" value="Add to Cart">
                                </form> 
                            </td>   
                        </tr>
                        <% } %>

                    </table>
                <%
                }


                if (session.getAttribute("searchGloves") != null && k == 2) { 
                    table = facade.getGloves("hej", u.getCon()); %>
                    <h2>Gloves</h2>
                                       <table>
                        <tr>
                            <th> Name </th>
                            <th> Price </th>
                            <th> Stock </th>
                        </tr>
                        <%
                            for (int i = 0; i < (int)table.get("size"); i++) {
                                Hashtable tmp = (Hashtable)table.get("Gloves"+i);
                        %>
                        <tr>
                            <td> <%= tmp.get("name")%></td> 
                            <td> <%= tmp.get("price")%></td> 
                            <td> <%= tmp.get("stock")%></td> 
                            <%String item = "Gloves"+i;%>
                            <td> 
                                <form method="get" action="shoppingcart.jsp">
                                <select name = "Amount"> 
                                    <% for(int z = 1;z <= (int)tmp.get("stock");z++){ %> 
                                        <option value = <%=z%>> <%= z %> </option>
                                    <% } %> 
                                </select>
                            </td> 
                                <input type="hidden" name="Item" value=<%=item%>>
                            <td> 
                                 <input type="submit" value="Add to Cart">
                                </form> 
                            </td>  
                        </tr>
                        <% } %>

                    </table>
                <%}
                if (session.getAttribute("searchPants") != null && k == 3) { 
                    table = facade.getPants("hej", u.getCon()); %>
                    <h2>Pants</h2>
                                       <table>
                        <tr>
                            <th> Name </th>
                            <th> Price </th>
                            <th> Stock </th>
                        </tr>
                        <%
                            for (int i = 0; i < (int)table.get("size"); i++) {
                                Hashtable tmp = (Hashtable)table.get("Pants"+i);
                        %>
                        <tr>
                            <td> <%= tmp.get("name")%></td> 
                            <td> <%= tmp.get("price")%></td> 
                            <td> <%= tmp.get("stock")%></td> 
                            <%String item = "Pants"+i;%>
                            <td> 
                                <form method="get" action="shoppingcart.jsp">
                                <select name = "Amount"> 
                                    <% for(int z = 1;z <= (int)tmp.get("stock");z++){ %> 
                                        <option value = <%=z%>> <%= z %> </option>
                                    <% } %> 
                                </select>
                            </td> 
                                <input type="hidden" name="Item" value=<%=item%>>
                            <td> 
                                 <input type="submit" value="Add to Cart">
                                </form> 
                            </td>
                        </tr>
                        <% } %>

                    </table>
                <% }} %>
    </body>
</html>

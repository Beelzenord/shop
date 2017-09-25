<%-- 
    Document   : ShowTable
    Created on : Sep 24, 2017, 10:32:20 PM
    Author     : Niklas
--%>

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
        <h1>Items for sale</h1>
        <%
            String username = (String)session.getAttribute("Name");
            String password = (String)session.getAttribute("Password");
            Facade facade = (Facade)session.getAttribute("Facade");
            User u = facade.getUser();
            Hashtable table = new Hashtable();
            String hej = "hej";
            for (int k = 0; k < 4; k++) {
                table = null;
                if (request.getParameter("Shoes") != null && k == 0) { 
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
                            <td> <select> <% for(int z = 1;z <= (int)tmp.get("stock");z++){
                                String s = "Shoes"+z;
                                    %> <option value = s> <%= z %>  </option> <%
                            } %> </select></td>   
                        </tr>
                        <% } %>

                    </table>
                <%}
                if (request.getParameter("Shirts") != null && k == 1) { 
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
                            <td> <select> <% for(int z = 1;z <= (int)tmp.get("stock");z++){
                                String s = "Shirts"+z;
                                    %> <option value = s> <%= z %>  </option> <%
                            } %> </select></td>   
                        </tr>
                        <% } %>

                    </table>
                <%
                }


                if (request.getParameter("Gloves") != null && k == 2) { 
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
                            <td> <select> <% for(int z = 1;z <= (int)tmp.get("stock");z++){
                                String s = "Gloves"+z;
                                    %> <option value = s> <%= z %>  </option> <%
                            } %> </select></td>   
                        </tr>
                        <% } %>

                    </table>
                <%}
                if (request.getParameter("Pants") != null && k == 3) { 
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
                            <td> <select> <% for(int z = 1;z <= (int)tmp.get("stock");z++){
                                String s = "Pants"+z;
                                    %> <option value = s> <%= z %>  </option> <%
                            } %> </select></td>
                            <td> <button onclick= "confirm.jsp" > Add to Cart </button> </td>
                        </tr>
                        <% } %>

                    </table>
                <% }} %>
    </body>
</html>

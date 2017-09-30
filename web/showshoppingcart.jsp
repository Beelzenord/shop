<%-- 
    Document   : ShowShoppingcart
    Created on : Sep 26, 2017, 12:04:12 PM
    Author     : Niklas
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Hashtable"%>
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
        <a href= "SearchItems.jsp"> Search for Items</a><br>
        <a href= "ShowTable.jsp"> Show Items</a><br>
        <%
            Facade facade = (Facade)session.getAttribute("Facade");
            Hashtable table = new Hashtable();

                    table = facade.getCart();
                    float total = 0;
        %>
                    <h2>Shopping Cart</h2>
                    <table>
                        <tr>
                            <th> Name </th>
                            <th> Price </th>
                            <th> Amount </th>
                        </tr>
                        <%
                            Enumeration e = table.keys();
                            while (e.hasMoreElements()) {
                                String item = (String)e.nextElement();
                                Hashtable tmp = (Hashtable)table.get(item);
                        %>
                        <tr>
                            <td> <%= tmp.get("name")%></td> 
                            <td> <%= tmp.get("price")%></td> 
                            <td> <%= tmp.get("amount")%></td> 
                            <td>
                            <form method="get" action="ControllerApplication">
                                <input type="hidden" name="Removed" value=<%=item%>>
                                <input type="hidden" name="actionType" value="RemoveFromCart">
                                <input type="submit" value="Remove">
                            </form> 
                            </td>
                        </tr>
                         <%  total += ((float)tmp.get("price") * (int)tmp.get("amount"));
                         } %>

                    </table>
                    <h3> 
                        <td> Total sum: </td> 
                        <td> <%= total%> </td>
                        <form method="get" action="ControllerApplication">
                            <input type="hidden" name="actionType" value="CreateOrder">
                            <input type="submit" value="Create Order">
                        </form> 
                    </h3>
    </body>
</html>

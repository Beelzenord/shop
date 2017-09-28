    <%-- 
    Document   : ShowOrders
    Created on : Sep 27, 2017, 4:26:10 PM
    Author     : Niklas
--%>

<%@page import="businesslogic.Facade"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Enumeration"%>
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
        <a href= "getitems.jsp"> Search for Items</a><br>
        <a href= "ShowTable.jsp"> Show Items</a><br><br><br>
        <%
            Facade facade = (Facade)session.getAttribute("Facade");
            Hashtable table = new Hashtable();
            
                    table = facade.getOrders("orders", facade.getUser().getCon());
                    float total = 0;
        %>
                    
                    <%
                        Enumeration e = table.keys();
                        while (e.hasMoreElements()) {
                    %>
                    
                    <table>
                        <tr>
                            <th> ID </th>
                            <th> Table Name </th>
                            <th> Amount </th>
                        </tr>
                        <%
                            int item = (int)e.nextElement();
                            Hashtable order = (Hashtable)table.get(item);
                            Enumeration e2 = order.keys();
                            int orderID = -1;
                            String username = "";
                            while (e2.hasMoreElements()) {
                                String item2 = (String)e2.nextElement();
                                Hashtable tmp = (Hashtable)order.get(item2);
                                orderID = (int)tmp.get("orderID");
                                username = (String)tmp.get("username");
                                %>
                                <tr>
                                    <td> <%= tmp.get("id")%></td> 
                                    <td> <%= tmp.get("tableName")%></td> 
                                    <td> <%= tmp.get("amount")%></td> 
                                </tr>
                            <% } %>
                    </table>
                    <h3> 
                        OrderID: <%=orderID%>      Username: <%=username%> 
                        <form method="get" action="ExecuteOrder.jsp">
                                <input type="hidden" name="Execute" value=<%=orderID%>>
                                <input type="submit" value="Create Order">

                        </form> 
                    </h3><br><br>
                    <% } %>
    </body>
</html>

<%-- 
    Document   : edituser
    Created on : Sep 27, 2017, 1:34:29 AM
    Author     : fauzianordlund
--%>
<%@page import="java.lang.String"%>
<%@page import="businesslogic.User"%>
<%@page import="java.util.Vector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Hashtable"%>
<%@page import="businesslogic.Admin"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Profiles</h1>
        
        <% Facade facade = (Facade)session.getAttribute("Facade");
           Admin a = facade.getAdmin();
           Vector meine_table = facade.getUsers();
           //out.println(meine_table.size());
           request.setAttribute("vector", meine_table);
        //   User u = (User)meine_table.get(1);
          // out.println(u.toString());
        
        %>
      
              
            <% 
            
                 for(int i = 0 ; i < meine_table.size() ; i++){
                 
                 User u = (User) meine_table.get(i);
                 
            %>
              <form method="get" action ="updateprocessor.jsp" scope = "session">
           
           Username   <input type = "text" name = "username" value ="<%= u.getUsername() %>"required>
           Password   <input type = "text" name = "password" value ="<%= u.getPassword() %>"required>
           First Name <input type = "text" name = "firstName" value ="<%= u.getFirstName()%>"required>
           Last  Name <input type = "text" name = "lastName"  value ="<%= u.getLastName()%>"required>
           Email      <input type = "text" name = "email"  value ="<%= u.getEmail() %>"required>
           <input type="hidden" name = "marker"  value = "<%= i%>"> 
           <input type="hidden" name ="ID" value="<%= u.getId() %>">
           <input type="submit" value ="update">
           <br/><br/></form>
            <% } %>    
           
            
        
      
    </body>
</html>

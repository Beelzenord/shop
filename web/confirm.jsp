<%-- 
    Document   : confirm
    Created on : Sep 24, 2017, 2:54:57 AM
    Author     : fauzianordlund
--%>

<%@page import="businesslogic.User"%>
<%@page import="businesslogic.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%  
           out.println("TOGGAF");
            RequestDispatcher ds = request.getRequestDispatcher("mainservices.jsp"); 
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          out.println(username);
          out.println(password);
          User u = Facade.getUserCredentials(username, password);
          out.println(u.toString());
          if(username.equals(u.getUsername())&&password.equals(u.getPassword())){
              ds.forward(request, response);
          }    
        %>
    </body>
</html>

<%-- 
    Document   : loginvalidation.jsp
    Created on : Sep 23, 2017, 3:48:41 PM
    Author     : fauzianordlund
--%>

<%@page import="businesslogic.Facade"%>
<%@page import="businesslogic.Visitor"%>
<%@page import="businesslogic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Validation</title>
    </head>
    <body>
    
    
        <%
                 String user=request.getParameter("username");
                 String pass=request.getParameter("password");
                 out.println(user);
                 out.println(pass);
                 User u = Facade.getUserCredentials( user, pass);
                 out.println("fine so far");
                 out.println(u.getUsername());
                 
                ServletRequest sr;
                ServletResponse rs;
               
                
                 if(u.isUserConnected()){
                   RequestDispatcher RD = request.getRequestDispatcher("mainservices.jsp");
                   RD.forward(request, response);
                 }
                 else{
                     out.println("sd");
                 }
                
            %>
    </body>
</html>

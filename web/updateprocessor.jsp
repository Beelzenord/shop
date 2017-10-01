<%-- 
    Document   : updateprocessor
    Created on : Sep 28, 2017, 1:06:11 PM
    Author     : fauzianordlund
--%>

<%@page import="datalayer.ValidateUser"%>
<%@page import="businesslogic.Admin"%>
<%@page import="businesslogic.Facade"%>
<%@page import="businesslogic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sample update</h1>
        
        <% 
            int    id       = Integer.parseInt(request.getParameter("ID"));
            int    marker   = Integer.parseInt(request.getParameter("marker"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName= request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email    = request.getParameter("email");
            String grant    = request.getParameter("grant");
            out.println(marker);
            out.println(id+ " " + username + " " + password + " " + 
                    " " + firstName + " " + lastName + " " + email);
            out.println("check validation : " + grant);
            Facade fc = (Facade) session.getAttribute("Facade");
            Admin a = fc.getAdmin();
            out.println(a.getCon());
            
            User preUpdate = new User(id,username,password,firstName,lastName,email);
            fc.updateUser(a.getCon(), preUpdate);
            if(grant.equals("granted")){
               ValidateUser.issueGrant(preUpdate, a.getCon());
               out.println("done");
            }
%>          
<a href="edituser.jsp"> back </a> 
        
    </body>
</html>

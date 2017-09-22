/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author fauzianordlund
 */
public class PrimitiveServlet implements Servlet{

    @Override
    public void init(ServletConfig sc) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public ServletConfig getServletConfig() {
           return null;
    }

    @Override
   public void service(ServletRequest request, ServletResponse response)
   throws ServletException, IOException {
    System.out.println("from service");
    PrintWriter out = response.getWriter();
    out.println("Forza Bajen");
    }

    @Override
    public String getServletInfo() {
           return null;
    }

    @Override
    public void destroy() {
      System.out.println("destroy");
    }
    
}

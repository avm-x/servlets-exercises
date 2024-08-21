import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_14 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_14</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_14: initial parameter from web.xml</h1>");
        out.println("<p>Write a program to read and display the Servlet's initial parameter from web.xml.</p>");
        
        ServletConfig config = getServletConfig();

        // Read the init parameters
        String username = config.getInitParameter("username");
        
        out.println("<span><b>Param: </b>" + username + "</span>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
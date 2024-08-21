import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_13_tracker extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_13</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_13: Tracker</h1>");
        out.println("<p>Write a session tracking program in Servlet by using Hidden Form Fields.</p>");
        String name = req.getParameter("fname");
        String sessionId = req.getParameter("sessionIdentifier");
        
        out.println("<span>Welcome "+ name + "</span><br>");
        out.println("<span>your sessionId is: "+ sessionId + "</span>");

        out.println("</BODY>");
        out.println("</HTML>");
    }

}
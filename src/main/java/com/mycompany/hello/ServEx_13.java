import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServEx_13 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_13</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_13: Tracking with hidden form fields</h1>");
        out.println("<p>Write a session tracking program in Servlet by using Hidden Form Fields.</p>");
        HttpSession session = req.getSession(true);
        String sId = session.getId();

        out.println(
            "<form name='loginForm' method='post' action='http://localhost:8080/servlets-exercises/servEx_13_tracker'>"
                    +
                    "firstname:<br/> <input type='text' name='fname'/> <br/>" +
                    "email:<br/><input type='email' name='email'/> <br/>" +
                    "<input type='hidden' name='sessionIdentifier' value='"+ sId +"' />" +
                    "<input type='submit' value='Send info' />" +
                    "</form>");


        
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
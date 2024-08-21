import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServEx_12 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_12</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_12: URL Rewriting: writing</h1>");
        out.println("<p>Write a Servlet program to track the session using URL rewriting.</p>");

        HttpSession session = req.getSession(true);
        String sId = session.getId();

        out.println("<a href='servEx_12_tracker?ssid=" + sId + "'>visit</a>");
        
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
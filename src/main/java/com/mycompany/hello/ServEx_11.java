import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_11 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_9</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_9: getAttribute </h1>");
        out.println("<p>Write a Servlet program to demonstrate the use of setAttribute and getAttribute methods.</p>");
        out.println("<b>You have been redirected directly from .../servEx_9 with a custom request attribute!</b>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>" + "Logs" + "</th>");
        out.println("<th>" + "" + "</th>");
        out.println("</tr>");

        out.println("</table>");

        out.println("</BODY>");
        out.println("</HTML>");
    }
}
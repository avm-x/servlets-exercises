import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet_Exc_Handler extends HttpServlet { 
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_10</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_10: RequestDispatcher Error Handling </h1>");
        out.println("<p>Write a Servlet program to demonstrate the use of setAttribute and getAttribute methods.</p>");
        out.println("<b>You have been redirected directly from .../servEx_Exc_prod with a custom request attribute!</b>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>" + "Error" + "</th>");
        out.println("<th>" + "Value" + "</th>");
        out.println("</tr>");
            out.println("<tr>");
            out.println("<td>error-exception:</td>");
            out.println("<td>" + req.getAttribute("error-exception") + "</td>");
            out.println("</tr>");

        out.println("</table>");

        out.println("</BODY>");
        out.println("</HTML>");

    }
}
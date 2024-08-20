import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_10 extends HttpServlet { 

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_10</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_9: Handling Exceptions</h1>");
        out.println("<p>Write a Servlet program to demonstrate Exceptions handling</p>");
        out.println(
        "<ul>" +
        "<li>" + "<span>Exception Handling using the deployment descriptor: </span>" + "<a href='http://localhost:8080/servlets-exercises/servEx_10'>click here</a>" + "</li>" +
        "</ul>");
        out.println("</BODY>");
        out.println("</HTML>");
    }


}
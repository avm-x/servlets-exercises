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
        out.println("<h1>ServEx_10: Handling Exceptions</h1>");
        out.println("<p>Write a Servlet program to demonstrate Exceptions handling</p>");
        out.println(
        "<ul>" +
        "<li>" + "<span><b>[X]</b> Exception Handling using the <b>deployment descriptor</b> (i.e. web.xml) : </span>" + "<a href='http://localhost:8080/servlets-exercises/this-address-is-invalid'>click here</a>" + "</li>" +
        "</ul><br>");

        out.println(
        "<ul>" +
        "<li>" + "<span><b>[X]</b> Exception Handling using the <b>RequestDispatcher</b>: </span>" + "<a href='http://localhost:8080/servlets-exercises/servlet_Exc_prod'>click here</a>" + "</li>" +
        "</ul><br>");

        out.println(
        "<ul>" +
        "<li>" + "<span><b>[X]</b> Exception Handling using the <b>log method</b>: </span>" + "<a href='http://localhost:8080/servlets-exercises/servlet_Exc_Logger'>click here</a>" + "</li>" +
        "</ul><br>");

        out.println("</BODY>");
        out.println("</HTML>");
    }


}
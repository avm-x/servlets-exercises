
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/Form")
public class ServEx_2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_2</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_2: Form</h1>");
        out.println(
                "<p>Design an HTML form to invoke a Servlet which should catch registrationNo,firstname and lastname from the client side and display the same to client side in HTML format.</p>");
        out.println(
                "<form name='loginForm' method='post' action='http://localhost:8080/servlets-exercises/servEx_2/handling-form'>"
                        +
                        "registrationNo: <input type='number' name='registrationNo'/> <br/>" +
                        "firstname: <input type='text' name='fname'/> <br/>" +
                        "lastname: <input type='text' name='sname'/> <br/>" +
                        "<input type='submit' value='Login' />" +
                        "</form>");
        out.println("</BODY>");
        out.println("</HTML>");

    }
}
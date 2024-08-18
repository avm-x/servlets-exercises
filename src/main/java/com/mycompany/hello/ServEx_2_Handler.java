
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_2_Handler extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Handling...</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_2: Handling Form</h1>");
        out.println("<h2> User form info: </h2>");
        out.println("<span><b>RegistrationNo: </b>" + req.getParameter("registrationNo") + "</span> <br/>");
        out.println("<span><b>first name: </b>" + req.getParameter("fname") + "</span> <br/>");
        out.println("<span><b>last name: </b>" + req.getParameter("sname") + "</span> <br/>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<h1>You should use the POST me</h1>");
    }
}
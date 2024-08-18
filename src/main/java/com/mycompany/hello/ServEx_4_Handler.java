
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_4_Handler extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_4</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_4: Handling Form</h1>");
        out.println("<h2>User info:</h2>");
        out.println("<table>");

        out.println("<tr>");
        out.println("<th> Field</th>");
        out.println("<th> Content</th>");
        out.println("</tr>");

        Enumeration paramNames = req.getParameterNames();

        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = String.valueOf(paramNames.nextElement());

            out.println("<tr>");
            out.println("<td>" + paramName + "</td>");
            out.println("<td>" + req.getParameter(paramName) + "</td>");
            out.println("</tr>");

        }

        out.println("</table>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<h1>You should use the POST me</h1>");
    }
}

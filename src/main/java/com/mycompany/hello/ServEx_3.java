import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServEx_3 extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String headersLine = "";

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_3</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_3: Header information</h1>");
        out.println("<h2>Header:</h2>");
        out.println("<table>");

        out.println("<tr>");
        out.println("<th> Headers</th>");
        out.println("<th> Content</th>");
        out.println("</tr>");
        out.println("</tr>");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames != null && headerNames.hasMoreElements()) {
            String headerName = String.valueOf(headerNames.nextElement());

            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + request.getHeader(headerName) + "</td>");
            out.println("</tr>");

        }

        out.println("</table>");
        out.println("");
        out.println("");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setHeader("Test", "Demo");
    }
}
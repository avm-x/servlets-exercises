import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_8_redirect extends HttpServlet {
        private HttpServletResponse tres;
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
            tres = res;
        PrintWriter out = res.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_8</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_8: Handling Form</h1>");
        out.println("<h2>Redirect info:</h2>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> Header</th>");
        out.println("<th> Content</th>");
        out.println("</tr>");
        Enumeration headerNames = req.getHeaderNames();

        while (headerNames != null && headerNames.hasMoreElements()) {
            String paramName = String.valueOf(headerNames.nextElement());

            out.println("<tr>");
            out.println("<td>" + paramName + "</td>");
            out.println("<td>" + req.getHeader(paramName) + "</td>");
            out.println("</tr>");

        }

        out.println("</table>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
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
        out.println("<button id='redirect-btn'>Redirect with res.sendRedirect()!</button>");
        out.println("</BODY>");
        out.println("</HTML>");

        out.println("<script>");
        out.println("document.getElementById('redirect-btn').addEventListener('click', function() {");
        out.println("    var xhr = new XMLHttpRequest();");
        out.println("    xhr.open('POST', 'servEx_8_redirect', true);");
        out.println("    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');");
        out.println("    xhr.onreadystatechange = function() {");
        out.println("        if (xhr.readyState === 4 && xhr.status === 200) {");
        out.println("            window.location.href = 'servEx_8';");
        out.println("        }");
        out.println("    };");
        out.println("    xhr.send('redirect=true');");
        out.println("});");
        out.println("</script>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
            // Handle the AJAX request for redirection
            res.sendRedirect("http://localhost:8080/servlets-exercises/servEx_8");
    }
}
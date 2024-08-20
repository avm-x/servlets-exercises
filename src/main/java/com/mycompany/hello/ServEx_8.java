import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_8 extends HttpServlet {
        private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_8</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_8: Redirect </h1>");
        out.println("<p>Write a Servlet program to redirect the url by using sendRedirect method and RequestDispatcher interface.</p>");
        out.println("<p></b>After clicking the button, you will be redirect to a redirect page that shows info about the headers</b></p>");
        out.println("<button id='redirect-btn'>Redirect with reqDispatchet.include(req, res)!</button>");
        out.println("</BODY>");
        out.println("</HTML>");

        out.println("<script>");
        out.println("document.getElementById('redirect-btn').addEventListener('click', function() {");
        out.println("    var xhr = new XMLHttpRequest();");
        out.println("    xhr.open('POST', 'servEx_8', true);");
        out.println("    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');");
        out.println("    xhr.onreadystatechange = function() {");
        out.println("        if (xhr.readyState === 4 && xhr.status === 200) {");
        out.println("            window.location.href = 'servEx_8_redirect';");
        out.println("        }");
        out.println("    };");
        out.println("    xhr.send('redirect=true');");
        out.println("});");
        out.println("</script>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       if (req.getParameter("redirect") != null) {
            // Handle the AJAX request for redirection
            RequestDispatcher reqD = req.getRequestDispatcher("servEx_8_redirect");
            reqD.include(req, res);
        }
    }
}
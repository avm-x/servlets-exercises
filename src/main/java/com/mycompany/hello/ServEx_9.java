import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_9 extends HttpServlet { 

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_9</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_9: setAttribute </h1>");
        out.println("<p>Write a Servlet program to demonstrate the use of setAttribute and getAttribute methods.</p>");
        out.println("<button id='forward-btn'>Forward req to displayerReq servlet</button>");
        out.println("</BODY>");
        out.println("</HTML>");
        req.setAttribute("what r u listening right now", "ardilla mc");

                out.println("<script>");
        out.println("document.getElementById('forward-btn').addEventListener('click', function() {");
        out.println("    var xhr = new XMLHttpRequest();");
        out.println("    xhr.open('POST', 'servEx_9', true);");
        out.println("    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');");
        out.println("    xhr.onreadystatechange = function() {");
        out.println("        if (xhr.readyState === 4 && xhr.status === 200) {");
        out.println("            window.location.href = 'servEx_9_handleReq';");
        out.println("        }");
        out.println("    };");
        out.println("    xhr.send('redirect=true');");
        out.println("});");
        out.println("</script>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if (req.getParameter("redirect") != null) {
            req.setAttribute("music", "testo");
            RequestDispatcher reqD = req.getRequestDispatcher("servEx_9_handleReq");
            reqD.forward(req, res);
        }
    }

}
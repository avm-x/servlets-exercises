import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet_Exc_Logger extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        try {
            throw new Exception("Custom Exception to log!!");
        } catch (Exception e) {
            log("Check out this Exception -> " + e.getMessage());
            PrintWriter out = res.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>ServEx_10.3</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("<h1>ServEx_10.3: Exception Logger </h1>");

            out.println("<b>Exception log successfully!</b>");
            out.println("</BODY>");
            out.println("</HTML>");

        
        }
    }

    
}
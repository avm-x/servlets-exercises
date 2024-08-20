import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet_Exc_prod extends HttpServlet { 
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        req.setAttribute("music", "corridos belicos");

        try {
            throw new RuntimeException("This is thrown intentionally for our exercise");
        } catch (Exception e) {
            req.setAttribute("error-exception", e.getMessage());

            RequestDispatcher rqDisH = req.getRequestDispatcher("servlet_Exc_Handler");
            rqDisH.forward(req, res);
        }

    }
}

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_7 extends HttpServlet {
   
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        LocalTime currentTime = LocalTime.now();


        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_7</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_7: Digital Clock</h1>");
        out.println("<p>Write a Servlet program to display digital clock in browser.</p>");
        out.println("<span id='hours'>0</span>");
        out.println("<span id='minutes'>0</span>");
        out.println("<span id='seconds'>0</span>");
        out.println("<script>var initialTime = '" + currentTime + "'</script>");
        out.println("<script src='./js/servex_7.js'></script>");
        out.println("</HTML>");
    }
}

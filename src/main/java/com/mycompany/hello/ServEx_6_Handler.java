import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServEx_6_Handler extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<link rel='stylesheet' href='../css/servex_6_handler.css'>");
        out.println("<TITLE>ServEx_6</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_6: Handling Form</h1>");
        out.println("  <div class='displayer-cont'>     <div class='d-head'>       <h2>Product table</h2>     </div>     <div class='d-body'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> code</th>");
        out.println("<th> name</th>");
        out.println("<th> weight</th>");
        out.println("<th> type</th>");
        out.println("</tr>");

        out.println("</table>");
        out.println("</div></div>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<h1>You should use the POST me</h1>");
    }
}

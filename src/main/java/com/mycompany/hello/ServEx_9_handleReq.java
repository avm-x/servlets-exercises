import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_9_handleReq extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Enumeration attrNames = req.getAttributeNames();
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_9</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_9: getAttribute </h1>");
        out.println("<p>Write a Servlet program to demonstrate the use of setAttribute and getAttribute methods.</p>");
        out.println("<b>You have been redirected directly from .../servEx_9 with a custom request attribute!</b>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>" + "Attributes" + "</th>");
        out.println("<th>" + "Values" + "</th>");
        out.println("</tr>");

        while(attrNames.hasMoreElements()){
            String attrName = (String) attrNames.nextElement();
            out.println("<tr>");
            out.println("<td>" + attrName + "</td>");
            out.println("<td>" + req.getAttribute(attrName) + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println(attrNames + "<-----------");
        out.println("</BODY>");
        out.println("</HTML>");
        
    }
    
}
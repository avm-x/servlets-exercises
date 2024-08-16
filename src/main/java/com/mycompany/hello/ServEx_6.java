import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServEx_6 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        int productsNum = 0;

        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<link rel='stylesheet' href='./css/servex_6.css'>");
        out.println("<TITLE>ServEx_6</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_6: Store and retrieve products</h1>");
        out.println("  <div class='displayer-cont'><div class='d-head'><h2>Product form</h2></div><div class='d-body'><form method='post' name='productForm' action='http://localhost:8080/servlets-exercises/servEx_6/handling-form'><div class='input-cont'><label for='code'>code<label><input type='text' name='code' id='code' placeholder='0000' maxlength='4'></div><div class='input-cont'><label for='name'>name<label><input type='text' name='name' id='name' placeholder='candy box'></div><div class='input-cont'><label for='weight'>weight(in grams)<label><input type='text' name='weight' id='weight' placeholder='500'></div><div class='input-cont'><label for='type'>type<label><input type='text' name='type' id='type' placeholder='food'></div><input type='submit' value='add product'></form></div><div class='dfooter'><span>Current products in store: </span>");
        out.println("<span>" + productsNum + "</span>" + "</div></div>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

}

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServEx_11 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_11</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_11: HttpSession interface && Cookies </h1>");
        out.println("<p>[o] Write a Servlet program to handle session by using <b>HttpSession interface.</b> <br>write a cookie in user's computer. Cookie name should be 'sessionid' and cookie value should be session's id. <br>retrieve the cookie from user's computer and display name and value of it. <br></p>");

        // 1._ Handling session
        HttpSession session = req.getSession();
        session.setAttribute("Music", "Corridos");
        out.println("<b>session attr music: </b>" + session.getAttribute("Music") + "<br>");
        // 2-
        Cookie cookie = new Cookie("sessionid", session.getId());
        res.addCookie(cookie);

        Cookie[] cookies = req.getCookies();

        if(cookies != null){
            for(Cookie cooki : cookies){
                out.println("<br>Cookie <b>name:</b> " + cooki.getName() + " <b>value: </b>" + cooki.getValue());
            }
        }
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
package com.mycompany.hello;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/src/css/styles.css";
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<head>");
        out.println("<link rel='stylesheet' type='text/css' href='" + url + "'/>");
        out.println("<TITLE>Hello Servlet</TITLE>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello Servlet");
        out.println("</body>");
        out.println("</HTML>");
    }
}
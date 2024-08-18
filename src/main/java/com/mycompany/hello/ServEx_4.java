
//package com.mycompany.hello;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServEx_4 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_3</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");

        out.println("<h1>ServEx_4: Form with more fields</h1>");
        out.println(
                "<p>Make a form to input the details of students like regno, first name, last name, phone, education and email and, display all the input values from Servlet by using Enumeration class.</p>");
        out.println(
                "<form name='loginForm' method='post' action='http://localhost:8080/servlets-exercises/servEx_4/handling-form'>"
                        +
                        "registrationNo:<br/><input type='number' name='registrationNo'/> <br/>" +
                        "firstname:<br/> <input type='text' name='fname'/> <br/>" +
                        "lastname:<br/><input type='text' name='lname'/> <br/>" +
                        "phone:<br/><input type='tel' name='phone'/> <br/>" +
                        "education:<br/><input type='text' name='education'/> <br/>" +
                        "email:<br/><input type='email' name='email'/> <br/>" +
                        "<input type='submit' value='Send info' />" +
                        "</form>");

        out.println("</BODY>");
        out.println("</HTML>");
    }

}

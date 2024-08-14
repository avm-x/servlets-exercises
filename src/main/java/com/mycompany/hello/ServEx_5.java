import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServEx_5 extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        System.out.println("HI");
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>ServEx_5</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_5: Inserting Record</h1>");
        out.println("<h2>Tables:</h2>");
        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/empDB";
            String username = "postgres";
            String password = "postgres";

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

            ResultSet createTable = statement
                    .executeQuery("CREATE TABLE employee (empno integer, name text, designation text, phone integer);");
            ResultSet createEmployee = statement
                    .executeQuery("INSERT INTO employee VALUES (0, 'jane', 'tester', 102003);");
            out.println("Checha a jane -> " + createEmployee.toString());

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            out.println("checa -> " + resultSet.toString());

            while (resultSet.next()) {
                String columnValue = resultSet.getString("column_name");
                out.println("Column Value: " + columnValue);
            }

            out.println("connected!");
        } catch (Exception e) {
            // TODO: handle exception
            out.println("NO connected! " + e);
            System.out.println(e + " ERROR");
        }

        out.println("</BODY>");
        out.println("</HTML>");
    }

}
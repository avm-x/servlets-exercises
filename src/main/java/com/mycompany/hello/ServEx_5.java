import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            String jdbcUrl = "jdbc:postgresql://localhost:5432/servexdb";
            String username = "postgres";
            String password = "avm";
            
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();



            // check if TABLE employee exist, if it doesNOT, insert new table
            if(!doesTableExist(connection, "employee")){
                statement.executeUpdate("CREATE TABLE employee (empno INTEGER, name TEXT, designation TEXT, phone BIGINT);");
            }
            
            int rowsAffected = statement.executeUpdate("INSERT INTO employee (empno, name, designation, phone) VALUES (1, 'jane', 'best friend', 41921);");

            if(rowsAffected > 0){
                ResultSet rs = statement.executeQuery("SELECT * FROM employee");
                out.println("connected. record inserted ");
                out.println(
                    "<table>" +
                    "<tr>" +
                     "<th>empno</th>" + 
                     "<th>name</th>" +
                     "<th>designation</th>" +
                     "<th>phone</th>" +
                    "</tr>");

                while(rs.next()){
                    int empno = rs.getInt("empno");
                    String name = rs.getString("name");
                    String designation = rs.getString("designation");
                    long phone = rs.getLong("phone");

                    out.print(
                        "<tr>" +
                            "<td>" + empno + "</td>" +
                            "<td>" + name + "</td>" +
                            "<td>" + designation + "</td>" +
                            "<td>" + phone + "</td>" +
                        "</tr>");
                }

                out.println("</table>");
                connection.commit();
            } else {
                out.println("connected. but record COULDNOT be inserted");
                connection.rollback();
            }

        } catch (Exception e) {
            // TODO: handle exception: TABLE employee doesn't exist:
            out.println(e + " ERROR");
        }

        out.println("</BODY>");
        out.println("</HTML>");
    }

    private static boolean doesTableExist(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        try (ResultSet resultSet = metaData.getTables(null, null, tableName, new String[] {"TABLE"})) {
            return resultSet.next();
        }
    }
}
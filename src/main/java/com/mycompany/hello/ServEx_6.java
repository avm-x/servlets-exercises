import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServEx_6 extends HttpServlet {
    private boolean tracker;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        long productsNum = 0;
        PrintWriter out = res.getWriter();
        
        try{
            String jdbcUrl = "jdbc:postgresql://localhost:5432/servexdb";
            String username = "postgres";
            String password = "";
                
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            // if table exist update number of products
            if(doesTableExist(connection, "products")){
                ResultSet retrieveRecords = statement.executeQuery("SELECT COUNT(*) FROM products;");
                productsNum = retrieveRecords.getLong(1);
                tracker = doesTableExist(connection, "products");
            } else {
                int rowsAffected = statement.executeUpdate("CREATE TABLE products (code INTEGER, name TEXT, weight FLOAT, type TEXT);");
                connection.commit();
                tracker = doesTableExist(connection, "products");
            }
        } catch(Exception E){
        }

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<link rel='stylesheet' href='./css/servex_6.css'>");
        out.println("<TITLE>ServEx_6</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<h1>ServEx_6: Store and retrieve products</h1>");
        out.println("  <div class='displayer-cont'><div class='d-head'><h2>Product form</h2></div><div class='d-body'><form method='post' name='productForm' action='http://localhost:8080/servlets-exercises/servEx_6/handling-form'><div class='input-cont'><label for='code'>code<label><input type='text' name='code' id='code' placeholder='0000' maxlength='4'></div><div class='input-cont'><label for='name'>name<label><input type='text' name='name' id='name' placeholder='candy box'></div><div class='input-cont'><label for='weight'>weight(in grams)<label><input type='text' name='weight' id='weight' placeholder='500'></div><div class='input-cont'><label for='type'>type<label><input type='text' name='type' id='type' placeholder='food'></div><input type='submit' value='add product'></form></div><div class='dfooter'><span>Current products in store: </span>");
        out.println("<span>" + productsNum + "</span>" + "<br/><span>Take into account that only unique products (in base to their code) are gonna be stored!</span>" + "</div></div>");
        out.println("Does table exist? " + tracker);
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public static boolean doesTableExist(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData dbMetaData = conn.getMetaData();
        try {
            ResultSet resultSet = dbMetaData.getTables(null, null, tableName, new String[] {"TABLE"});
            return resultSet.next();
        } catch (Exception e) {
            return false;
        }
    }

}

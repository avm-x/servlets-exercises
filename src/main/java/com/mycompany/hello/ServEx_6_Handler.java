import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServEx_6_Handler extends HttpServlet {
    private ResultSet rsProd;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        int pcode = Integer.valueOf(req.getParameter("code"));
        String pname = req.getParameter("name");
        float pweight = Float.valueOf(req.getParameter("weight"));
        String ptype = req.getParameter("type");

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

                try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/servexdb";
            String username = "postgres";
            String password = "";
                
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            // check if code product is unique, if it is, store the product.
            ResultSet countOfDuplicates = statement.executeQuery("SELECT COUNT(*) FROM products WHERE code ='" + pcode + "';");
           
            if(countOfDuplicates.next() ){
                int duplicates = countOfDuplicates.getInt(1);
                if(duplicates > 0){
                    out.println("duplicates found " + duplicates + " - where code is " + pcode);
                } else {
                    int rowsAffected = statement.executeUpdate("INSERT INTO products (code, name, weight, type) VALUES ("+ pcode + ", '" + pname +"', " + pweight + ", '" + ptype +"');");
                    if(rowsAffected > 0){
                        out.println("The new product was added successfully to the database.");
                    }
                }
            }

            rsProd = statement.executeQuery("SELECT * FROM products;");

            connection.commit();

        } catch(Exception e){
            out.println("There was an error while trying to check for duplicates " + e.getMessage());
        }

        try {
                while(rsProd.next()){
                    out.println("<tr>");
                    out.println("<td>"+ rsProd.getInt("code") +"</td>");
                    out.println("<td>"+ rsProd.getString("name")+"</td>");
                    out.println("<td>"+ rsProd.getFloat("weight")+"</td>");
                    out.println("<td>"+ rsProd.getString("type")+"</td>");
                    out.println("</tr>");
            }

        } catch(Exception e){
            out.println("There was an error while trying to display the db products in table");
        }


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

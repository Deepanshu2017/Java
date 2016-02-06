import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Display extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.execute("Select * from student");
            ResultSet resultSet = statement.getResultSet();
            PrintWriter writer = response.getWriter();
            writer.print("<!DOCTYPE html><html lang='utf-8'><head><meta charset='utf-8' /><title>Record</title></head>");
            writer.print("<body><table border='2'><tr>");
            writer.print("<th>Roll</th><th>Name</th><th>Per</th><th>Edit</th><th>Delete</th></tr>");
            while(resultSet.next()) {
                writer.print("<tr>");
                writer.print("<td>" + resultSet.getString(1) + "</td>");
                writer.print("<td>" + resultSet.getString(2) + "</td>");
                writer.print("<td>" + resultSet.getString(3) + "</td>");
                writer.print("<td><a href='EditServlet?roll=" + resultSet.getString(1) + "'>Edit</a></td>");
                writer.print("<td><a href='DeleteServlet?roll=" + resultSet.getString(1) + "'>Delete</a></td></tr>");
            }
            resultSet.close();
            statement.close();
            connection.close();
            writer.print("</table>");
            writer.print("<a href='AddServlet'>Add new record</a></body></html>");
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

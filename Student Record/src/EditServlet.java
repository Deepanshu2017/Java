import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where roll=" + Integer.parseInt(request.getParameter("roll")));
            PrintWriter writer = response.getWriter();
            writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Edit page</title></head><body>");
            if(resultSet.next()) {
                writer.print("<form action='Update' method='post'>");
                writer.print("Roll &nbsp;&nbsp; <input type='text' name='roll' value='" + resultSet.getString(1) + "' readonly/><br />");
                writer.print("Name &nbsp;&nbsp; <input type='text' name='name' value='" + resultSet.getString(2) + "' /><br />");
                writer.print("Per &nbsp;&nbsp; <input type='text' name='per' value='" + resultSet.getString(3) + "' /><br />");
                writer.print("<input type='submit' name='submit' value='submit' /><br />");
                writer.print("</form>");
            } else {
                writer.print("Cannot find record");
            }
            resultSet.close();
            statement.close();
            connection.close();
            writer.print("</body></html>");
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

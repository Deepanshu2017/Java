import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            Statement statement = connection.createStatement();
            statement.execute("delete from student where roll=" + Integer.parseInt(request.getParameter("roll")));
            statement.close();
            connection.close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Display");
        requestDispatcher.forward(request, response);
    }
}

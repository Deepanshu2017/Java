import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Update extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("update student set name=?, per=? where roll=?");
            preparedStatement.setString(1, request.getParameter("name"));
            preparedStatement.setFloat(2, Float.parseFloat(request.getParameter("per")));
            preparedStatement.setInt(3, Integer.parseInt(request.getParameter("roll")));
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Display");
        requestDispatcher.forward(request, response);
    }
}

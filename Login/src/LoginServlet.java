import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    public boolean closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html><head><title>Login Servlet</title></head><body>");
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/website", "root", "password");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.execute("create table if not exists details(user varchar(20) not null, password varchar(200) not null)");
//            statement.execute("create table if not exists details(user varchar(20) not null, password text not null)");
            String username = request.getParameter("user");
            String password = request.getParameter("password");
            statement.execute("select * from details where user='" + username + "' and password='" + password + "'");
//            statement.execute("select * from details where user='" + username + "' and password=sha2('" + password + "', 512)");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()) {
                writer.print("<h1>Welcome to my first website with database</h1><br />");
                closeAll(resultSet, statement, connection);
            } else {
                writer.print("We cannot find your recode try again<br />");
                closeAll(resultSet, statement, connection);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.include(request, response);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        writer.print("</body></html>");
        writer.close();
    }
}

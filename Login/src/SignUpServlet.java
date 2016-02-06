import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignUpServlet extends HttpServlet {

    public boolean closeAll(Statement statement, Connection connection) {
        try {
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
        writer.print("<!DOCTYPE html><html><head><title>Signup page</title></head><body>");
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String retype = request.getParameter("retype");
        if(!password.equals(retype)) {
            writer.print("<h1>Retype doesn't match</h1>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.html");
            requestDispatcher.include(request, response);
        } else {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/website", "root", "password");
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                statement.execute("create table if not exists details(user char(20) not null, password varchar(200) not null)");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into details values (?, ?)");

//                statement.execute("create table if not exists details(user char(20) not null, password text not null)");
//                PreparedStatement preparedStatement = connection.prepareStatement("insert into details values (?, sha2(?, 512))");

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.execute();
                writer.print("<h1>Welcome to my first website with database</h1><br />");
                closeAll(statement, connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        writer.print("</body></html>");
        writer.close();
    }
}

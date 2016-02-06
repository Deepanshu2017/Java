import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginCheck extends HttpServlet {

    public boolean print(HttpServletRequest request, HttpServletResponse response, boolean value) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        if(value) {
            writer.print("<!DOCTYPE html><html lang='en'><body><h1>Welcome</h1></body></html>");
            writer.close();
        }
        else {
            writer.close();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
            requestDispatcher.forward(request, response);
        }
        return true;
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String km = request.getParameter("km");
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/website", "root", "password");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.execute("select * from details where name='" + username + "' and password='" + password + "'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()) {
                if("Keep me".equals(km)) {
                    Cookie cookie = new Cookie("username", username);
                    Cookie cookie_1 = new Cookie("password", password);
                    cookie.setMaxAge(200);
                    cookie_1.setMaxAge(200);
                    response.addCookie(cookie);
                    response.addCookie(cookie_1);
                }
                print(request, response, true);
            } else {
                print(request, response, false);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

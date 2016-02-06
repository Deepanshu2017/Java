import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandler extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer status_code = (Integer)(request.getAttribute("javax.servlet.error.status_code"));
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print("You are getting status code of: " + status_code);
    }
}
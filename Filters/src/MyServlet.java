import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("You cannot see this message with ip 127.0.0.1\n");
        out.print(request.getRemoteAddr() + "\n");
        out.print(request.getRemoteHost() + "\n");
        out.close();
    }
}
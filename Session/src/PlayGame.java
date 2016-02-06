import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PlayGame")
public class PlayGame extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
            return;
        }
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Play</title><body>");
        writer.print("Playing game <br />");
        writer.print("<a href='/Logout'>Logout</a></body></html>");
    }
}

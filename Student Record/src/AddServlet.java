import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Add record</title></head><body>");
        writer.print("<form action='InsertServlet' method='post'>");
        writer.print("Roll &nbsp;&nbsp <input type='text' name='roll' /><br />");
        writer.print("Name &nbsp;&nbsp <input type='text' name='name' /><br />");
        writer.print("Per &nbsp;&nbsp <input type='text' name='per' /><br />");
        writer.print("<input type='submit' name='submit' value='submit' /><br /></form></body></html>");
        writer.close();
    }
}
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SetupServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Middle page</title><body>");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        writer.print("<form action='FinalServlet?name=" + name +"&telephone=" + telephone + "' method='post'>");
        writer.print("Mail<input type='text' name='email' />");
        writer.print("<input type='submit' name='submit' value='submit'/>");
        writer.print("</form></body></html>");
        writer.close();
    }
}
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FinalServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Final page</title><body>");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        writer.print("name: " + name + "<br />telephone: " + telephone + "<br />email: " + email);
        writer.print("</body></html>");
        writer.close();
    }
}
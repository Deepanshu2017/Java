import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MiddleServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookies[] = request.getCookies();
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.print("<!DOCTYPE html><html lang='en'><body>");
        if (cookies != null) {
            String username="", password="";
            for(int i = 0; i < cookies.length; ++i) {
                if(cookies[i].getName().equals("username"))
                    username = cookies[i].getValue();
                if(cookies[i].getName().equals("password"))
                    password = cookies[i].getValue();
            }
//            writer.print("<a href='LoginCheck?username=" + username + "&password=" + password + "'>Click</a>");
            RequestDispatcher rd = request.getRequestDispatcher("/LoginCheck?username=" + username + "&password=" + password);
            rd.include(request, response);
        } else {
            writer.print("<form action='LoginCheck' method='get'>");
            writer.print("<input type='text' name='username' value=''/><br />");
            writer.print("<input type='text' name='password' value=''/><br />");
            writer.print("<input type='checkbox' name='km' value='Keep me'/><br />");
            writer.print("<input type='submit' name='submit' value='submit'/>");
            writer.print("</form>");
        }
        writer.print("</body></html>");
        writer.close();
    }
}
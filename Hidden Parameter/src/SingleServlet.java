import javax.servlet.*;
import java.io.*;

public class SingleServlet implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig config) throws ServletException { this.config = config; }
    public void destroy() {}
    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        int count = 0;
        if(request.getParameter("count") != null)
            count = Integer.parseInt(request.getParameter("count"));
        if(request.getParameter("submit").equals("inc"))
            ++count;
        else
            --count;
        writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' /><title>Single</title></head><body>");
        writer.print("Variable is: " + count + "<br />");
        writer.print("<form action='SingleServlet' method='post'>");
        writer.print("<input type='submit' name='submit' value='inc' />");
        writer.print("<input type='submit' name='submit' value='dec' />");
        writer.print("<input type='hidden' name='count' value='" + count + "' />");
        writer.print("</form></body></html>");
        writer.close();
    }
    public ServletConfig getServletConfig() { return config; }
    public String getServletInfo() { return "This is Single Servlet"; }
}
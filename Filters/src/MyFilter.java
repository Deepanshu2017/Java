import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String ip = request.getRemoteAddr();
        HttpServletResponse response1 = null;
        if(response instanceof HttpServletResponse)
            response1 = (HttpServletResponse)response;
        if(response1 != null && ip.equals("127.0.0.1"))
            response1.sendError(HttpServletResponse.SC_NOT_FOUND, "You are blocked: " + request.getRemotePort());
        else
            chain.doFilter((HttpServletRequest)request, response1);
    }
    public void destroy() {

    }
}
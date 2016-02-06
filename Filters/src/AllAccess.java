import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//import java.util.GregorianCalendar;

public class AllAccess extends HttpServlet {
    public void service(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
//        response.addIntHeader("Refresh", 2);
        if(session.isNew())
            session.setAttribute("Girl", 1);
        else
            session.setAttribute("Girl", 1 + (Integer)(session.getAttribute("Girl")));
        PrintWriter out = response.getWriter();
        out.print("User count is: " + (Integer)session.getAttribute("Girl") + "\n");
        out.print(session.getId() + "\n");
        out.print(new Date(session.getCreationTime()) + "\n");
        out.print(new Date(session.getLastAccessedTime()) + "\n");
        String filename = request.getParameter("uf");
        SaveFile.myMain(filename);
//        Calendar calendar = new GregorianCalendar();
//        int hour = calendar.get(Calendar.HOUR);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        String am_pm = (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM");
//        out.print("Time is: " + hour + ":" + minute + ":" + second + " " + am_pm);
    }
}

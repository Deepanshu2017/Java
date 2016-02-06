import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;

@MultipartConfig
public class Submit extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");
        String l2;
        if(language.equals(".py3"))
            l2 = ".py";
        else
            l2 = language;
        Part part = request.getPart("file");
        File uploads = new File("/home/deepanshu/Desktop/Project");
        File file = new File(uploads, "Main" + l2);
        try (InputStream input = part.getInputStream()) {
            Files.copy(input, file.toPath());
        }
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        boolean compiled = Compiler.compile(language);
        writer.print("Compilation is: " + (compiled ? "Successful" : "Failed") + "\n");
        if(compiled) {
            boolean run = Run.run(language, "/home/deepanshu/Desktop/Project/in.txt", 1000);
            writer.print("Verdict is: " + (run ? "Passed" : "Failed") + "\n");
        }
    }
}
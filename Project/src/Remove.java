import java.io.File;
import java.io.IOException;

public class Remove {
    public static void remove(String language) {
        ProcessBuilder p;
        if(language.equals(".c"))
            p = new ProcessBuilder("rm", "-rf", "Main", "Main.c", "out.txt");
        else if(language.equals(".cpp"))
            p = new ProcessBuilder("rm", "-rf", "Main", "Main.cpp", "out.txt");
        else if(language.equals(".java"))
            p = new ProcessBuilder("rm", "-rf", "Main.class", "Main.java", "out.txt");
        else
            p = new ProcessBuilder("rm", "-rf", "Main.py", "out.txt");
        p.directory(new File("/home/deepanshu/Desktop/Project"));
        try {
            Process process = p.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
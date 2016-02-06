import java.io.*;
import java.util.concurrent.*;
public class Run {
    public static boolean run(String language, String name, long timeInMillis) {
        System.out.println("Code started executing.");
        ProcessBuilder p;
        if (language.equals(".java")) {
            p = new ProcessBuilder("java", "-cp", ".", "Main");
        } else if (language.equals(".c")) {
            p = new ProcessBuilder("./Main");
        } else if (language.equals(".cpp")) {
            p = new ProcessBuilder("./Main");
        } else if (language.equals(".py")) {
            p = new ProcessBuilder("python", "Main.py");
        } else if (language.equals(".py3")) {
            p = new ProcessBuilder("python3", "Main.py");
        } else
            return false;
//        p.directory(new File(System.getProperty("user.dir")));
        p.directory(new File("/home/deepanshu/Desktop/Project/"));
        File in = new File(name);
        p.redirectInput(in);
        if(in.exists())
            System.out.println("Input file " + in.getAbsolutePath());
        p.redirectErrorStream(true);
//        System.out.println("Current directory " + System.getProperty("user.dir"));
//        File out = new File(System.getProperty("user.dir") + "/out.txt");

        File out = new File("/home/deepanshu/Desktop/Project/out.txt");
        p.redirectOutput(out);
        if(out.exists())
            System.out.println("Output file generated " + out.getAbsolutePath());
        try {
            Process pp = p.start();
            if (!pp.waitFor(timeInMillis, TimeUnit.MILLISECONDS)) {
                System.out.println("TLE");
                Remove.remove(language);
                return false;
            }
            int exitCode = pp.exitValue();
            System.out.println("Exit Value = " + exitCode);
            if(exitCode != 0) {
                System.out.println("RUNTIME ERROR" + exitCode);
                Remove.remove(language);
                return false;
            }
        } catch (IOException ioe) {
            System.err.println("in execute() "+ioe);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        System.out.println("Code execution finished!");
        System.out.println("RUN SUCCESS");
        boolean result = Matched.match();
        Remove.remove(language);
        return result;
    }
}
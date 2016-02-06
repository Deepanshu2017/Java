import java.io.*;
public class Compiler {
    public static boolean compile(String language) {

        System.out.println("Code compilation started...");
        ProcessBuilder p;
        boolean compiled = true;
        if (language.equals(".java")) {
            p = new ProcessBuilder("javac", "Main.java");
        } else if (language.equals(".c")) {
            p = new ProcessBuilder("gcc", "-std=gnu99", "-w", "-O2", "-fomit-frame-pointer", "-lm", "-o", "Main", "Main.c");
        } else if (language.equals(".cpp")){
            p = new ProcessBuilder("g++", "-std=c++14", "-w", "-O2", "-fomit-frame-pointer", "-lm", "-o", "Main", "Main.cpp");
        } else{
            return true;
        }
//        p.directory(new File(System.getProperty("user.dir")));
        p.directory(new File("/home/deepanshu/Desktop/Project/"));
        p.redirectErrorStream(true);

        try {
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            String temp;
            try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
                while ((temp = b.readLine()) != null) {
                    compiled = false;
                    System.out.println(temp);
                }
                pp.waitFor();
            }

            if (!compiled) {
                is.close();
                System.out.println("COMPILE_ERROR");
                return false;
            }
            is.close();
            System.out.println("COMPILE_SUCCESS");
            return true;
        } catch (IOException | InterruptedException e) {
            System.out.println("in compile() " + e);
        }
        System.out.println("COMPILE_ERROR");
        return false;
    }
}
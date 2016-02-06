import java.io.*;

public class Matched {
    public static boolean match() {
        BufferedReader b1 = null, b2 = null;
        File f1, f2;
        try {
            System.out.println("Matching process started.");
            f1 = new File("/home/deepanshu/Desktop/Project/output");
            System.out.println("Test output exists? [" + f1.exists() + "] Path=" + f1.getAbsolutePath());
            f2 = new File("/home/deepanshu/Desktop/Project/out.txt");
            System.out.println("Output exists? [" + f2.exists() + "] Path=" + f2.getAbsolutePath());
            b1 = new BufferedReader(new FileReader(f1));
            b2 = new BufferedReader(new FileReader(f2));

            String s1 = "", s2 = "", temp;
            while ((temp = b2.readLine()) != null) {
                s2 += temp.trim() + "\n";
            }
            System.out.println(f2.getName() + ":\n" + s2);
            while ((temp = b1.readLine()) != null) {
                s1 += temp.trim() + "\n";
            }
            System.out.println(f1.getName() + ":\n" + s1);
            System.out.println("Matching ended.");
            if (s1.equals(s2)) {
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            System.err.println("in match() "+ex);
        } finally {
            try {
                b1.close();
                b2.close();
            } catch (IOException | NullPointerException ex) {
                System.err.println("in match() "+ex);
            }
        }
        return false;
    }
}
import java.io.*;
import java.util.*;

public class WordMorph {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) throws IOException{
        StringBuilder start = new StringBuilder(r.readLine());
        StringBuilder end = new StringBuilder(r.readLine());

        HashSet<String> dict = new HashSet<>();
        while (r.ready()) {
            String temp = r.readLine();
            if (temp.length() == start.length()) {
                dict.add(temp);
            }
        }

        Queue<StringBuilder> next = new LinkedList<>();
        Queue<Integer> dis = new LinkedList<>();

        next.add(start);
        dis.add(0);
        dict.remove(start.toString());

        while (!next.isEmpty() && !dis.isEmpty()) {
            StringBuilder cur = next.poll();
            int changes = dis.poll();

            if (cur.toString().equals(end.toString())) {
                pw.println(changes);
                break;
            }
            for (int i = 0; i < cur.length(); i ++) {
                for (char c : alphabet) {
                    StringBuilder temp = new StringBuilder(cur);
                    temp.setCharAt(i, c);

                    if (dict.contains(temp.toString())) {
                        next.add(temp);
                        dis.add(changes + 1);
                        dict.remove(temp.toString());
                    }
                }
            }
        }
        pw.close();
    }
}


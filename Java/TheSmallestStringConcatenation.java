import java.io.*;
import java.util.*;

public class TheSmallestStringConcatenation {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        String[] strings = new String[N];
        for (int i = 0; i < N; i ++) {
            strings[i] = r.readLine();
        }

        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for (String i : strings) {
            pw.print(i);
        }
        pw.println();
        pw.close();
    }
}

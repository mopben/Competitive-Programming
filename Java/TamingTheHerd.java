import java.io.*;
import java.util.*;

public class TamingTheHerd {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));

        int N = Integer.parseInt(r.readLine());

        int[] log = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            log[i] = Integer.parseInt(st.nextToken());
        }
        int[] breakouts = new int[N];
        Arrays.fill(breakouts, -1);
        breakouts[0] = 0;
        for (int i = N-1; i >= 0; i --) {
            for (int j = 0; j <= log[i]; j ++) {
                if (breakouts[i - j] != log[i] - j && breakouts[i - j] != -1) {
                    pw.println(-1);
                    pw.close();
                    System.exit(0);
                }
                breakouts[i - j] = log[i] - j;
            }
        }
        int minBreakouts = 0;
        int maxBreakouts = 0;
        for (int i = 0; i < N; i ++) {
            if (breakouts[i] == 0) {
                minBreakouts ++;
                maxBreakouts ++;
            }
            if (breakouts[i] == -1)
                maxBreakouts ++;
        }
        pw.println(minBreakouts + " " + maxBreakouts);
        pw.close();
    }
}
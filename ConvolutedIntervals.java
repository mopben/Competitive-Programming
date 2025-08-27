import java.io.*;
import java.util.*;

public class ConvolutedIntervals {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] start = new long[m + 1];
        long[] end = new long[m + 1];

        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            start[first] ++;
            end[last] ++;
        }

        long[] startSums = new long[2 * m + 1];
        long[] endSums = new long[2 * m + 1];
        for (int i = 0; i <= m; i ++) {
            for (int j = 0; j <= m; j ++) {
                startSums[i + j] += start[i] * start[j];
                endSums[i + j] += end[i] * end[j];
            }
        }
        long startWins = startSums[0];
        long endWins = (long) n * (long) n;

        for (int i = 0; i <= m * 2; i ++) {
            if (i > 0) {
                startWins += startSums[i];
                endWins -= endSums[i - 1];
            }
            pw.println(startWins + endWins - ((long) n * (long) n));
        }

        pw.close();
    }
}

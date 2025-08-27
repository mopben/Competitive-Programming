import java.io.*;
import java.util.*;

public class MaximumSubarraySum {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("mootube.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));

        final int N = Integer.parseInt(r.readLine());

        int[] arr = new int[N];
        long[] sums = new long[N + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            sums[i + 1] = sums[i] + Integer.parseInt(st.nextToken());
        }

        long min = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i ++) {
            ans = Math.max(ans, sums[i] - min);
			min = Math.min(min, sums[i]);
        }
        pw.println(ans);
        pw.close();
    }
}
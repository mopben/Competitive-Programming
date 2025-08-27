import java.io.*;
import java.util.*;

public class MultiplicationTable {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(r.readLine());
        final long expectedVal = (((long) N * N) + 1) / 2;

        long low = 0; long high = (long) N * N;

        while (low < high) {
            long middle = (low + high) / 2;

            if (findLesserAndEqual(middle) >= expectedVal) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static long findLesserAndEqual(long val) {
        long counter = 0;
        for (int i = 1; i <= N; i ++) {
            counter += Math.min(N, val / i);
        }
        return counter;
    }
}
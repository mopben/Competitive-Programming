import java.io.*;
import java.util.*;

public class SocialDistancingSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int M;
    static long[][] intervals;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        intervals = new long[M][2];
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        Arrays.sort(intervals, Comparator.comparingLong(value -> value[0]));

        long low = 0; long high = (long) Math.pow(10,18);

        while (low < high) {
            long middle = (low + high + 1) / 2;

            if (checkValid(middle)) {
                low = middle;
            }
            else {
                high = middle - 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(long maxSpace) {
        int interval = 0;
        boolean works = true;
        long lastCow = (long) -Math.pow(10, 18);

        for (int i = 0; i < N; i ++) {
            while (interval < M && intervals[interval][1] - lastCow < maxSpace) {
                interval ++;
            }
            if (interval >= M) {
                works = false;
                break;
            }

            lastCow = Math.max(intervals[interval][0], lastCow + maxSpace);
        }
        return works;
    }
}
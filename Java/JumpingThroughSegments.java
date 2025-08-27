import java.io.*;
import java.util.*;

public class JumpingThroughSegments {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(r.readLine());
            long[][] segments = new long[n][2];
            for (int j = 0; j < n; j ++ ){
                StringTokenizer st = new StringTokenizer(r.readLine());
                long start = Integer.parseInt(st.nextToken());
                long end = Integer.parseInt(st.nextToken());
                segments[j] = new long[] {start, end};
            }

				long lo = 0; long hi = (long) Math.pow(10, 9) + 1;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (checkAnswer(mid, segments)) {
                    hi = mid;
                }
                else {
                    lo = mid + 1;
                }
            }
            System.out.println(hi);
        }
    }
    public static boolean checkAnswer(long k, long[][] segments) {
        long lowLimit = -k;
        long highLimit = k;
        for (int i = 0; i < segments.length; i ++) {
            if (highLimit >= segments[i][0] && lowLimit <= segments[i][1]) {
                lowLimit = Math.max(segments[i][0], lowLimit) - k;
                highLimit = Math.min(segments[i][1], highLimit) + k;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
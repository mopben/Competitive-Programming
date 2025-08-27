import java.io.*;
import java.util.*;

public class Pond {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static int k;
    static int[][] heights;
    static int numMoreThanMedian;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        numMoreThanMedian = (int) Math.pow(k, 2) - (int) (Math.pow(k, 2) / 2 + 1);
        if (k % 2 == 0) {
            numMoreThanMedian ++;
        }

        heights = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < n; j ++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long low = 0; long high = (long) Math.pow(10, 9);
        while (low < high) {
            long mid = (low + high) / 2;

            if (checkValid(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(long median) {

        int[][] prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + (heights[i - 1][j - 1] > median ? 1 : 0);
            }
        }

        for (int i = 1; i <= n - k + 1; i ++) {
            for (int j = 1; j <= n - k + 1; j ++) {
                if (prefix[i + k - 1][j + k - 1] - prefix[i - 1][j + k - 1] - prefix[i + k - 1][j - 1] + prefix[i - 1][j - 1] <= numMoreThanMedian) {
                    return true;
                }
            }
        }

        return false;
    }
}


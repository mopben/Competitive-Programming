import java.io.*;
import java.util.*;

public class FairPhotography {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int[][] cows;
    static int[] sums;
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("fairphoto.in")));
		PrintWriter pw = new PrintWriter(new FileWriter("fairphoto.out")));

        N = Integer.parseInt(r.readLine());

        cows = new int[N + 1][2];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = st.nextToken().charAt(0) == 'G' ? 1 : -1;
        }
        cows[N][0] = Integer.MAX_VALUE;

        Arrays.sort(cows, Comparator.comparingInt(value -> value[0]));

        sums = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            sums[i + 1] = sums[i] + cows[i][1];
        }

        pw.println(Math.max(checkDecreasing(), Math.max(checkIncreasing(), checkEqual())));
        pw.close();
    }
    public static int checkDecreasing() {
        int res = 0;
        int start = 0;

        for (int i = 1; i <= N; i ++) {

            if (sums[i] > sums[i - 1]) {
                start = i;
            }
            res = Math.max(cows[i - 1][0] - cows[start][0], res);
        }
        return res;
    }
    public static int checkIncreasing() {
        int res = 0;
        int start = 0;

        for (int i = 1; i <= N; i ++) {

            if (sums[i] < sums[i - 1]) {
                start = i;
            }
            res = Math.max(cows[i - 1][0] - cows[start][0], res);
        }
        return res;
    }
    public static int checkEqual() {

        int res = 0;

        int[] leftMost = new int[N * 2 + 1];
        Arrays.fill(leftMost, -1);

        for (int i = 0; i <= N; i ++) {
            if (leftMost[sums[i] + N] == -1) {
                leftMost[sums[i] + N] = cows[i][0];
            }
            else {
                res = Math.max(res, cows[i - 1][0] - leftMost[sums[i] + N]);
            }
        }
        return res;
    }
}

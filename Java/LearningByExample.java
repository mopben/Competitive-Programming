import java.io.*;
import java.util.*;

public class LearningByExample {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        int[][] cows = new int[N+2][2];
        for (int i = 1; i <= N; i ++) {
            st = new StringTokenizer(r.readLine());
            cows[i][0] = st.nextToken().charAt(0) == 'S' ? 1 : 0;
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        cows[0][1] = -1_000_000_000;
        cows[N+1][1] = 1_000_000_000;
        Arrays.sort(cows, Comparator.comparingInt(value -> value[1]));

        int ans = 0;
        for (int i = 0; i <= N; i ++) {
            int mid = (cows[i][1] + cows[i + 1][1]) / 2;

            if (cows[i][0] == 1) {
                int left = Math.max(A, cows[i][1] + 1);
                int right = Math.min(B, mid);
                ans += Math.max(0, right - left + 1);
            }
            if (cows[i + 1][0] == 1) {
                int left = Math.max(A, mid + 1);
                int right = Math.min(B, cows[i + 1][1]);
                ans += Math.max(0, right - left + 1);
            }
            if (cows[i][0] == 0 && cows[i + 1][0] == 1 && cows[i][1] % 2 == cows[i + 1][1] % 2 && mid >= A && mid <= B) {
                ans ++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}

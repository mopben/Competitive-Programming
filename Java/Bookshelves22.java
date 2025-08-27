import java.io.*;
import java.util.*;

public class Bookshelves22 {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        solve();
    }
    private static void solve() throws IOException{
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] bookshelves = new int[N];
        for (int i = 0; i < N; i ++) {
            bookshelves[i] = Integer.parseInt(r.readLine());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < Math.pow(2, N); i ++) {
            int sum = 0;
            for (int j = 0; j < N; j ++) {
                if ((i & 1 << j) > 0) {
                    sum += bookshelves[j];
                }
            }
            if (sum >= B) {
                ans = Math.min(ans, sum - B);
            }
        }
        pw.println(ans);
        pw.close();
    }
}
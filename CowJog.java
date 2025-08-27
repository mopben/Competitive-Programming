import java.io.*;
import java.util.*;

public class CowJog {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i --) {
            if (cows[i][1] <= min) {
                min = cows[i][1];
                ans ++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}


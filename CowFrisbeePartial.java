import java.io.*;
import java.util.*;

public class CowFrisbeePartial {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());

        int[] cows = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for (int i = 0; i < n; i ++) {
            long maxVal = 0;
            for (int j = i + 1; j < n; j ++) {
                if (maxVal < cows[j]) {
                    ans += j - i + 1;
                }
                if (cows[j] > cows[i]) {
                    break;
                }
                maxVal = Math.max(maxVal, cows[j]);
            }
        }

        pw.println(ans);
        pw.close();
    }
}
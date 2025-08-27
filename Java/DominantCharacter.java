import java.io.*;
import java.util.*;

public class DominantCharacter {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(r.readLine());
            char[] s = r.readLine().toCharArray();

            int[] sumA = new int[n + 1];
            int[] sumB = new int[n + 1];
            int[] sumC = new int[n + 1];

            for (int j = 1; j <= n; j ++) {
                sumA[j] = sumA[j - 1];
                sumB[j] = sumB[j - 1];
                sumC[j] = sumC[j - 1];

                if (s[j - 1] == 'a') {
                    sumA[j] ++;
                }
                if (s[j - 1] == 'b') {
                    sumB[j] ++;
                }
                if (s[j - 1] == 'c') {
                    sumC[j] ++;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j ++) {
                for (int k = 2; k <= 7; k ++) {
                    if (j + k - 1 > n) {
                        continue;
                    }
                    int numberOfA = sumA[j + k - 1] - sumA[j - 1];
                    int numberOfB = sumB[j + k - 1] - sumB[j - 1];
                    int numberOfC = sumC[j + k - 1] - sumC[j - 1];
                    if (numberOfA > numberOfB && numberOfA > numberOfC) {
                        ans = Math.min(ans, k);
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                pw.println(-1);
            }
            else {
                pw.println(ans);
            }
        }
        pw.close();
    }
}
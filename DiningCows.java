import java.io.*;
import java.util.*;

public class DiningCows {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[] preference = new int[N];
        for (int i = 0; i < N; i ++) {
            preference[i] = Integer.parseInt(r.readLine());
        }
        int[] prefNum1 = new int[N + 1];
        int[] prefNum2 = new int[N + 1];
        int[] sufNum1 = new int[N + 1];
        int[] sufNum2 = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            prefNum1[i + 1] = prefNum1[i];
            prefNum2[i + 1] = prefNum2[i];

            if (preference[i] == 1) {
                prefNum1[i + 1] ++;
            }
            else {
                prefNum2[i + 1] ++;
            }
            sufNum1[N - i - 1] = sufNum1[N - i];
            sufNum2[N - i - 1] = sufNum2[N - i];

            if (preference[N - i - 1] == 1) {
                sufNum1[N - i - 1] ++;
            }
            else {
                sufNum2[N - i - 1] ++;
            }
        }

        int ans = N;
        for (int i = 0; i < N; i ++) {
            ans = Math.min(ans, prefNum1[i] + sufNum1[i]);
            ans = Math.min(ans, prefNum2[i] + sufNum2[i]);
            ans = Math.min(ans, prefNum2[i] + sufNum1[i]);
        }
        pw.println(ans);
        pw.close();
    }
}

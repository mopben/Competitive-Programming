import java.io.*;
import java.util.*;

public class LemonadeLine {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lemonade.out"));

        int n = Integer.parseInt(r.readLine());

        int[] cows = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());

        for (int i = 0; i < n; i ++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows);

        int ans = 0;
        for (int i = n - 1; i >= 0; i --) {
            if (cows[i] < ans) {
                break;
            }
            ans ++;
        }
        pw.println(ans);
        pw.close();
    }
}

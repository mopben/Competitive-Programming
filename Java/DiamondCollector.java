import java.io.*;
import java.util.*;

public class DiamondCollector {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("diamond.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] diamonds = new int[N];
        for (int i = 0; i < N; i ++) {
            diamonds[i] = Integer.parseInt(r.readLine());
        }

        Arrays.sort(diamonds);

        int[] maxPrefix = new int[N + 1];
        int[] prefix = new int[N];
        int j = 0;
        for (int i = 0; i < N; i ++) {
            while (j < i && diamonds[i] - diamonds[j] > K) {
                j ++;
            }
            prefix[i] = j;
            maxPrefix[i + 1] = Math.max(maxPrefix[i], i - prefix[i] + 1);
        }

        int[] maxSuffix = new int[N + 1];
        int[] suffix = new int[N];

        j = N - 1;
        for (int i = N - 1; i >= 0; i --) {
            while (j > i && diamonds[j] - diamonds[i] > K) {
                j --;
            }
            suffix[i] = j;
            maxSuffix[i + 1] = Math.max(maxSuffix[i], suffix[i] - i + 1);
        }

        int ans = 0;
        for (int i = 1; i < N; i ++) {
            ans = Math.max(ans, maxPrefix[i] + maxSuffix[i + 1]);
        }
        pw.println(ans);
        pw.close();
    }
}

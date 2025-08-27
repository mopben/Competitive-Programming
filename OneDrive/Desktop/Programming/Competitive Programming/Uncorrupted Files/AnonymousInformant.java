import java.io.*;
import java.util.*;

public class AnonymousInformant {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n + 1];
            st = new StringTokenizer(r.readLine());
            for (int j = 1; j <= n; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            arr[0] = arr[n];

            long nextIndex = n;
            String ans = "Yes";
            BitSet visited = new BitSet();

            for (int j = 0; j < k; j ++) {
                if (arr[(int) (nextIndex % n)] > n) {
                    ans = "No";
                    break;
                }
                if (visited.get((int) (nextIndex % n))) {
                    break;
                }
                visited.set((int) (nextIndex % n));
                nextIndex += n - arr[(int) (nextIndex % n)];
            }
            System.out.println(ans);
        }
    }
}
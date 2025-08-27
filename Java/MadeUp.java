import java.io.*;
import java.util.*;

public class MadeUp {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            a[Integer.parseInt(st.nextToken()) - 1] ++;
        }

        long[] pairs = new long[N];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            int val = Integer.parseInt(st.nextToken()) - 1;
            pairs[i] += a[val];
        }

        long ans = 0;
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            int val = Integer.parseInt(st.nextToken()) - 1;
            ans += pairs[val];
        }
        pw.println(ans);
        pw.close();
    }
}
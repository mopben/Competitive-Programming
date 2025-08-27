import java.io.*;
import java.util.*;

public class GcdOnBlackboard {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        int[] suffix = new int[N+1];
        for (int i = 0; i < N; i ++) {
            prefix[i + 1] = findGCD(prefix[i], arr[i]);
            suffix[N - i - 1] = findGCD(suffix[N - i], arr[N - i - 1]);
        }

        int ans = 0;
        for (int i = 0; i < N; i ++) {
            ans = Math.max(ans, findGCD(prefix[i], suffix[i + 1]));;
        }
        pw.println(ans);
        pw.close();
    }
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
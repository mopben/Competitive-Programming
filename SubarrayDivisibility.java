import java.io.*;
import java.util.*;

public class SubarrayDivisibility {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long ans = 0;
        int[] sumsMod = new int[N];

        sumsMod[0] ++;

        for (int i = 0; i < N; i ++) {
            sum += arr[i];
            int mod = (int) ((sum % N) + N) % N;
            ans += sumsMod[mod];
            sumsMod[mod] ++;
        }
        pw.println(ans);
        pw.close();
    }
}

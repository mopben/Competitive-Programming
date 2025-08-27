import java.io.*;
import java.util.*;

public class SubarraySumsII{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        HashMap<Long, Integer> counter = new HashMap<>();
        counter.put(0L,1);

        long sum = 0;
        long ans = 0;
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= n; i ++) {
            sum += Integer.parseInt(st.nextToken());
            counter.putIfAbsent(sum - x, 0);
            ans += counter.get(sum - x);

            counter.putIfAbsent(sum,0);
            counter.put(sum,counter.get(sum) + 1);
        }
        pw.println(ans);
        pw.close();
    }
}
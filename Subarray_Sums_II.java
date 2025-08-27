import java.io.*;
import java.util.*;

public class Subarray_Sums_II{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0,1);

        int sum = 0;
        int ans = 0;
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= n; i ++) {
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            if (counter.containsKey(x - num))
                ans += counter.get(x - num);

            counter.putIfAbsent(sum, 0);
            counter.put(sum,counter.get(sum) + 1);
        }
        pw.println(ans);
        pw.close();
    }
}
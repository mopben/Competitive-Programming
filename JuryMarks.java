
import java.io.*;
import java.util.*;

public class JuryMarks{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] sums = new int[k+1];
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= k; i ++) {
            int mark = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1] + mark;
        }

        HashSet<Integer> values = new HashSet<>();
        TreeSet<Integer> values2 = new TreeSet<>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            int val = Integer.parseInt(st.nextToken());
            values.add(val);
            values2.add(val);
        }

        HashSet<Integer> scores = new HashSet<>();
        for (int i = 1; i <= k; i ++) {
            scores.add(values2.first() - sums[i]);
        }
        int ans = 0;
        for (int i : scores) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = 1; j <= k; j ++)
                seen.add(i + sums[j]);

            if (seen.containsAll(values))
                ans ++;
        }
        pw.println(ans);
        pw.close();
    }
}

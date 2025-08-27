import java.io.*;
import java.util.*;

public class SubsequencesSummingToSevens {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("div7.out"));
        int n = Integer.parseInt(r.readLine());

        int[] min = new int[7];
        int[] max = new int[7];
        Arrays.fill(min, Integer.MAX_VALUE);
        int sum = 0;
        for (int i = 1; i <= n; i ++) {
            sum += Integer.parseInt(r.readLine());
            sum %= 7;
            min[sum] = Math.min(min[sum],i);
            max[sum] = i;
        }
        int ans = 0;
        for (int i = 0; i < 7; i ++) {
            ans = Math.max(ans, max[i] - min[i]);
        }
        pw.println(ans);
        pw.close();
    }
}
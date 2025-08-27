import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class FactoryMachines {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static int t;
    static int[] time;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        time = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        long low = 0; long high = 1_000_000_000_000_000_000L;

        while (low < high) {
            long mid = (low + high) / 2;

            if (checkValid(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(long minTime) {
        BigInteger productsMade = BigInteger.valueOf(0);
        for (int i = 0; i < n; i ++) {
            productsMade = productsMade.add(BigInteger.valueOf(minTime / time[i]));
        }
        return productsMade.compareTo(BigInteger.valueOf(t)) >= 0;
    }
}

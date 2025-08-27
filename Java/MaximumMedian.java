import java.io.*;
import java.util.*;

public class MaximumMedian{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static int[] arr;
    public static int n;
    public static int k;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        pw.println(solve());
        pw.close();
    }
    public static long solve() {
        long low = 0; long high = Integer.MAX_VALUE;
        while (low < high) {
            long middle = (low + high + 1) / 2;
            long operationsRequired = findOperations(middle);

            if (operationsRequired <= k)
                low = middle;
            else
                high = middle - 1;
        }
        return low;
    }
    public static long findOperations(long x) {
        long counter = 0;
        for (int i = n / 2; i < n; i ++)
            counter += Math.max(0, x - arr[i]);
        return counter;
    }
}
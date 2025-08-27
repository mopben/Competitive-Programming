import java.io.*;
import java.util.*;

public class InsertAndEqualize {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(r.readLine());

            long[] arr = new long[n];
            long max = -Integer.MAX_VALUE;
            HashSet<Long> numbers = new HashSet<>();
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 0; j < n; j ++) {
                arr[j] = Long.parseLong(st.nextToken());
                numbers.add(arr[j]);
                max = Math.max(arr[j], max);
            }
            // Calculate GCD for all numbers
            long curGCD = 0;
            for (int j = 0; j < n; j ++ ) {
                curGCD = gcd(curGCD, max - arr[j]);
            }

            curGCD = Math.max(1, curGCD);

            // Operations for all numbers except the added number
            long ans = 0;
            for (int j = 0; j < n; j ++ ) {
                ans += (max - arr[j]) / curGCD;
            }

            // Add in the extra number
            long curNum = max - curGCD;
            long extraOperations = 1;
            while (numbers.contains(curNum)) {
                curNum -= curGCD;
                extraOperations ++;
            }

            System.out.println(Math.min(ans + extraOperations, ans + n));
        }
    }
    public static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
import java.io.*;
import java.util.*;

public class Moorbles {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i ++ ) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            long n = Long.parseLong(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] minEvens = new int[m];
            int[] maxEvens = new int[m];
            int[] minOdds = new int[m];
            int[] maxOdds = new int[m];
            for (int j = 0; j < m; j ++) {
                minEvens[j] = Integer.MAX_VALUE;
                minOdds[j] = Integer.MAX_VALUE;
                maxEvens[j] = Integer.MIN_VALUE;
                maxOdds[j] = Integer.MIN_VALUE;
            }
            for (int j = 0; j < m; j ++) {
                st = new StringTokenizer(r.readLine());
                for (int a = 0; a < k; a ++) {
                    int nextMove = Integer.parseInt(st.nextToken());
                    if (nextMove % 2 == 0) { // even
                        minEvens[j] = Math.min(minEvens[j], nextMove);
                        maxEvens[j] = Math.max(maxEvens[j], nextMove);
                    } else { // odd
                        minOdds[j] = Math.min(minOdds[j], nextMove);
                        maxOdds[j] = Math.max(maxOdds[j], nextMove);
                    }
                }
            }

            long[] sums = new long[m + 1];
            for (int j = m - 1; j >= 0; j --) {
                if (minEvens[j] != Integer.MAX_VALUE && minOdds[j] != Integer.MAX_VALUE) { // both even and odd
                    sums[j] = sums[j + 1] - Math.min(maxEvens[j], maxOdds[j]);
                }
                else if (minEvens[j] != Integer.MAX_VALUE) { // only even
                    sums[j] = sums[j + 1] + minEvens[j];
                    minOdds[j] = 0;
                    maxOdds[j] = 0;
                }
                else { // only odd
                    sums[j] = sums[j + 1] + minOdds[j];
                    minEvens[j] = 0;
                    maxEvens[j] = 0;
                }
            }

            ArrayList<String> ans = new ArrayList<>();

            if (n + sums[0] <= 0) {
                System.out.println(-1);
            }
            else {
                for (int j = 0; j < m; j ++) {
                    if (n - maxOdds[j] > 0 && n - maxOdds[j] + sums[j + 1] > 0) {
                        ans.add("Even");
                        n -= maxOdds[j];
                        if (maxOdds[j] == 0) {
                            n += minEvens[j];
                        }
                    } else if (n - maxOdds[j] > 0 && maxOdds[j] == 0 && n + minEvens[j] + sums[j + 1] > 0) {
                        ans.add("Even");
                        n += minEvens[j];
                    } else {
                        ans.add("Odd");
                        n -= maxEvens[j];
                        if (maxEvens[j] == 0) {
                            n += minOdds[j];
                        }
                    }
                }
                for (int j = 0; j < ans.size() - 1; j ++) {
                    System.out.print(ans.get(j) + " ");
                }
                System.out.println(ans.get(ans.size() - 1));
            }
        }
    }
}
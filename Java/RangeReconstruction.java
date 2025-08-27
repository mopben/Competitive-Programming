import java.io.*;
import java.util.*;

public class RangeReconstruction {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        //input-------------------------------------------------------------------------
        int n = Integer.parseInt(r.readLine());

        long[][] range = new long[n + 1][n + 1]; //first index is start, second index is end
        for (int i = 1; i <= n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = i; j <= n; j ++) {
                range[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //arrays-----------------------------------------------------------------------------
        long[] ans = new long[n + 1];	
        long[] min = new long[n + 1];
        long[] max = new long[n + 1];

        for (int i = 1; i <= n; i ++) {
            min[i] = Integer.MAX_VALUE;
            max[i] = Integer.MIN_VALUE;
        }

        //solve-------------------------------------------------------------------------------
        for (int i = 1; i <= n; i ++) {
            long val1 = ans[i - 1] + range[i - 1][i];
            long val2 = ans[i - 1] - range[i - 1][i];
            boolean good1 = true; //if val1 works
            boolean good2 = true; //if val2 works
            for (int j = i - 1; j > 0; j --) {
                if (range[j][i - 1] < range[j][i]) {
                    if (val1 - min[j] != range[j][i]) {
                        good1 = false;
                    }
                    if (max[j] - val2 != range[j][i]) {
                        good2 = false;
                    }
                }
                else {
                    if (val1 - min[j] > range[j][i]) {
                        good1 = false;
                    }
                    if (max[j] - val2 > range[j][i]) {
                        good2 = false;
                    }
                }
            }
            //update min and max
            if (good1) {
                ans[i] = val1;
                for (int j = i; j > 0; j --) {
                    max[j] = Math.max(max[j], val1);
                }
                for (int j = i; j > 0; j --) {
                    min[j] = Math.min(min[j], val1);
                }
            }
            else{
                assert good2;
                ans[i] = val2;
                for (int j = i; j > 0; j --) {
                    max[j] = Math.max(max[j], val1);
                }
                for (int j = i; j > 0; j --) {
                    min[j] = Math.min(min[j], val2);
                }
            }
        }

        //make sure answers aren't negative
        long minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i ++) {
            minVal = Math.min(minVal, ans[i]);
        }
        minVal = minVal < 0 ? Math.abs(minVal) : 0;

        for (int i = 1; i < n; i ++) {
            System.out.print(ans[i] + minVal + " ");
            assert ans[i] < Math.pow(10, 9);
        }
        System.out.println(ans[n] + minVal);

    }
}
import java.io.*;
import java.util.*;

public class SumOfThreeValues {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Integer.parseInt(st.nextToken());

        long[] values = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            values[i] = Integer.parseInt(st.nextToken());

        long[] loc = values.clone();

        Arrays.sort(values);
        long val1 = 0;
        long val2 = 0;
        long val3 = 0;
        for (int i = 0; i < n; i ++) {
            int j = 0;
            int k = n-1;
            while (j != k) {
                long sum = values[i] + values[j] + values[k];

                if (sum == x && i != j && i != k) {
                    for (int r = 0; r < n; r ++) {
                        if (val1 == 0 && values[i] == loc[r])
                            val1 = r + 1;
                        else if (val2 == 0 && values[j] == loc[r])
                            val2 = r + 1;
                        else if (val3 == 0 && values[k] == loc[r])
                            val3 = r + 1;
                    }
                    pw.println(val1 + " " + val2 + " " + val3);
                    pw.close();
                    System.exit(0);
                }

                if (sum > x) {
                    sum += values[k -1];
                    sum -= values[k];
                    k --;
                }
                else {
                    sum += values[j+1];
                    sum -= values[j];
                    j ++;
                }
            }
        }
        pw.println("IMPOSSIBLE");
        pw.close();

    }
}
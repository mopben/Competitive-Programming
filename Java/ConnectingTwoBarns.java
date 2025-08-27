import java.io.*;
import java.util.*;

public class ConnectingTwoBarns {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] values = new int[n];
            LinkedList<Integer>[] paths = new LinkedList[n];

            for (int j = 0; j < n; j ++) {
                paths[j] = new LinkedList<>();
            }

            for (int j = 0; j < m; j ++) {
                st = new StringTokenizer(r.readLine());
                int field1 = Integer.parseInt(st.nextToken()) - 1;
                int field2 = Integer.parseInt(st.nextToken()) - 1;

                if (field1 < field2) {
                    paths[field1].add(field2);
                }
                else {
                    paths[field2].add(field1);
                }
            }

            for (int j = n - 2; j >= 0; j --) {
                int maxVal = 0;
                for (int k : paths[j]) {
                    maxVal = Math.max(maxVal, (k - j) + values[k]);
                }
                if (paths[j].size() == 0) {
                    values[j] = values[j + 1];
                }
                values[j] += maxVal;
            }
            pw.println(n - values[0] - 1);
        }
        pw.close();
    }
}


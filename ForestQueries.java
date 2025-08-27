import java.io.*;
import java.util.*;

public class ForestQueries {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());

        int[][] forest = new int[N][N];
        for (int i = 0; i < N; i ++) {
            String temp = r.readLine();
            for (int j = 0; j < N; j ++) {
                forest[i][j] = temp.charAt(j) == '.' ? 0 : 1;
            }
        }
        int[][] sums = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + forest[i-1][j-1];
            }
        }

        for (int i = 0; i < Q; i ++) {
            st = new StringTokenizer(r.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pw.println(sums[y2][x2] - sums[y1-1][x2] - sums[y2][x1-1] + sums[y1-1][x1-1]);
        }
        pw.close();
    }
}

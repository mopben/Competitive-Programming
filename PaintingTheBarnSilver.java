import java.io.*;
import java.util.*;

public class PaintingTheBarnSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static final int MAX = 1_000;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("paintbarn.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] sums = new int[MAX+1][MAX+1];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1;
            int y1 = Integer.parseInt(st.nextToken()) + 1;
            int x2 = Integer.parseInt(st.nextToken()) + 1;
            int y2 = Integer.parseInt(st.nextToken()) + 1;
            sums[y1][x1] ++;
            sums[y2][x2] ++;
            sums[y2][x1] --;
            sums[y1][x2] --;
        }

        for (int i = 1; i <= MAX; i ++) {
            for (int j = 1; j <= MAX; j ++) {
                sums[i][j] += sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= MAX; i ++) {
            for (int j = 1; j <= MAX; j ++) {
                if (sums[i][j] == K) {
                    ans ++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
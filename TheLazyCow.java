import java.io.*;
import java.util.*;

public class TheLazyCow {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("lazy.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lazy.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int SIZE = N * 2;
        int[][] grass = new int[SIZE][SIZE];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                grass[j + i + 1][N - j + i] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sums = new int[SIZE][SIZE];
        for (int i = 1; i < SIZE; i ++) {
            for (int j = 1; j < SIZE; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + grass[i][j];
            }
        }
        
        int ans = 0;
        for (int i = 1; i < SIZE; i ++) {
            for (int j = 1; j < SIZE; j ++) {
                int x1 = Math.max(1, j - K);
                int y1 = Math.max(1, i - K);
                int x2 = Math.min(SIZE - 1, j + K);
                int y2 = Math.min(SIZE - 1, i + K);

                ans = Math.max(ans, sums[y2][x2] - sums[y1 - 1][x2] - sums[y2][x1 - 1] + sums[y1 - 1][x1 - 1]);
            }
        }
        pw.println(ans);
        pw.close();

    }
}
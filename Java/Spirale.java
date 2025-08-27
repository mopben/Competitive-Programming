import java.io.*;
import java.util.*;

public class Spirale {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static int m;
    static int[][] spiral;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        spiral = new int[n][m];

        for (int i = 0; i < n; i ++) {
            Arrays.fill(spiral[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < K; i ++) {

            st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) == 0 ? 1 : -1;

            simulate(x, y, dir);
        }
        for (int y = 0; y < n; y ++) {
            for (int x = 0; x < m - 1; x ++) {
                pw.print(spiral[y][x] + " ");
            }
            pw.println(spiral[y][m - 1]);
        }
        pw.close();
    }
    public static void simulate(int startX, int startY, int dir) {
        int[] dirY = {0, 1, 0, -1};
        int[] dirX = {-1, 0, 1, 0}; //for counterclockwise do -dX[i]
        int x = startX;
        int y = startY;
        int number = 1;

        for (int turns = 2; turns <= (Math.max(startY, Math.max(n - startY, Math.max(startX, m - startX)))) * 4 + 2; turns ++) {

            for (int steps = 0; steps < turns / 2; steps ++) {
                if (y >= 0 && y < m && x >= 0 && x < n) {
                    spiral[x][y] = Math.min(spiral[x][y], number);
                }

                number ++;
                x += dirX[(turns + 2) % 4];
                y += dirY[(turns + 2) % 4] * dir;
            }
        }
    }
}

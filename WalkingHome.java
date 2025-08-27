import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int[] dX = {1, 0};
    static int[] dY = {0, 1};
    static int ans;
    static int n;
    static int k;
    static char[][] grid;
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grid = new char[n][n];
            for (int j = 0; j < n; j ++) {
                grid[j] = r.readLine().toCharArray();
            }
            ans = 0;
            dfs(0, 0, -1, -1);
            pw.println(ans);
        }
        pw.close();
    }
    public static void dfs(int x, int y, int direction, int turns) {

        if (turns > k) {
            return;
        }
        if (y == n - 1 && x == n - 1) {
            ans ++;
            return;
        }

        for (int i = 0; i < 2; i ++) {
            int nY = y + dY[i];
            int nX = x + dX[i];
            if (nY >= 0 && nY < n && nX >= 0 && nX < n && grid[nY][nX] != 'H') {
                if (i != direction) {
                    dfs(nX, nY, i, turns + 1);
                }
                else {
                    dfs(nX, nY, i, turns);
                }
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class SwitchingOnTheLights {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static boolean[][] visited;
    static boolean[][] lit;
    static int n;
    static final int[] dX = {1, -1, 0, 0};
    static final int[] dY = {0, 0, 1, -1};
    static LinkedList<Pair>[][] switches;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lightson.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        switches = new LinkedList[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                switches[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            switches[y][x].add(new Pair(a, b));
        }
        visited = new boolean[n][n];
        lit = new boolean[n][n];

        lit[0][0] = true;

        floodFill(0, 0);

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (lit[i][j]) {
                    ans ++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static void floodFill(int x, int y) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;

        for (Pair p : switches[y][x]) {
            lit[p.y][p.x] = true;

            if (reachable(p.x, p.y)) {
                floodFill(p.x, p.y);
            }
        }

        for (int k = 0; k < 4; k ++) {
            int nX = x + dX[k];
            int nY = y + dY[k];

            if (nX >= 0 && nX < n && nY >= 0 && nY < n && !visited[nY][nX] && lit[nY][nX]) {
                floodFill(nX, nY);
            }
        }
    }
    public static boolean reachable(int x, int y) {
        for (int k = 0; k < 4; k ++) {
            int nX = x + dX[k];
            int nY = y + dY[k];

            if (nX >= 0 && nX < n && nY >= 0 && nY < n && visited[nY][nX]) {
                return true;
            }
        }
        return false;
    }
}
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
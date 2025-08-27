import java.io.*;
import java.util.*;

public class BronzeLillypad {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int M1 = Integer.parseInt(st.nextToken());
        final int M2 = Integer.parseInt(st.nextToken());

        Cord start = null;
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 3) {
                    start = new Cord(j, i);
                }
            }
        }
        assert start != null;

        int[] dX = new int[] {M1, M2, -M1, -M2, M1, M2, -M1, -M2};
        int[] dY = new int[] {M2, M1, M2, M1, -M2, -M1, -M2, -M1};

        boolean[][] visited = new boolean[N][M];
        int[][] dis = new int[N][M];
        Queue<Cord> next = new LinkedList<>();

        visited[start.y][start.x] = true;
        next.add(start);

        while (!next.isEmpty()) {
            int x = next.peek().x;
            int y = next.peek().y;
            next.poll();

            if (grid[y][x] == 4) {
                pw.println(dis[y][x]);
                break;
            }

            for (int i = 0; i < 8; i ++) {
                int nX = x + dX[i];
                int nY = y + dY[i];

                if (nX >= 0 && nX < M && nY >= 0 && nY < N && !visited[nY][nX] && (grid[nY][nX] == 1 || grid[nY][nX] == 4)) {
                    next.add(new Cord(nX, nY));
                    visited[nY][nX] = true;
                    dis[nY][nX] = dis[y][x] + 1;
                }
            }
        }
        pw.close();
    }
}
class Cord {
    int x;
    int y;

    public Cord (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
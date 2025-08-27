import java.io.*;
import java.util.*;

public class CrossCountrySkiing {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int[][] elevations;
    static boolean[][] waypoints;
    static boolean[][] visited;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("ccski.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        elevations = new int[M][N];
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                elevations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        waypoints = new boolean[M][N];
        int xLoc = -1;
        int yLoc = -1;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    waypoints[i][j] = true;
                    yLoc = i;
                    xLoc = j;
                }
            }
        }
        visited = new boolean[M][N];

        int low = 0; int high = 1_000_000_000;
        while (low < high) {
            int middle = (low + high) / 2;

            if (checkValid(middle, xLoc, yLoc))
                high = middle;
            else
                low = middle + 1;
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(int difficulty, int x, int y) {
        if (x == -1)
            return true;

        visited = new boolean[M][N];
        dfs(elevations[y][x], difficulty, x,y);
        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                if (waypoints[i][j] && !visited[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void dfs(int prevElevation, int difficulty, int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M)
            return;
        if (visited[y][x] || Math.abs(elevations[y][x] - prevElevation) > difficulty)
            return;
        visited[y][x] = true;
        dfs(elevations[y][x], difficulty,x+1, y);
        dfs(elevations[y][x], difficulty, x-1, y);
        dfs(elevations[y][x], difficulty, x, y+1);
        dfs(elevations[y][x], difficulty,x, y-1);
    }
}
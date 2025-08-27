import java.io.*;
import java.util.*;

public class CowBeautyPageant {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int M;
    static char[][] grid;
    static final int[] dR = {1,-1,0,0};
    static final int[] dC = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("pageant.in"));
		PrintWriter pw = new PrintWriter(new FileWirter("pageant.in"));
		
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        for (int i = 0; i < N; i ++) {
            grid[i] = r.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][M];
        int component = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (grid[i][j] == 'X' && !visited[i][j] && component == 0) {
                    findConnected(i, j, '0', visited);
                    component = 1;
                }
                else if (grid[i][j] == 'X' &&!visited[i][j] && component == 1) {
                    findConnected(i, j, '1', visited);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M ; j ++) {
                if (grid[i][j] == '0') {
                    ans = Math.min(ans, bfs(i,j));
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static int bfs (int r, int c) {
        Queue<Cord> next = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];
        next.add(new Cord(r, c, 0));

        int res = 0;
        while (!next.isEmpty()) {

            Cord cord = next.poll();

            if (grid[cord.r][cord.c] == '1') {
                res = cord.dis;
                break;
            }

            for (int i = 0; i < 4; i ++) {
                int nR = cord.r + dR[i];
                int nC = cord.c + dC[i];

                if (nR >= 0 && nR < N && nC >= 0 && nC < M) {
                    if (!visited[nR][nC]) {
                        next.add(new Cord(nR, nC, cord.dis + 1));
                        visited[nR][nC] = true;
                    }
                }
            }
        }
        return res - 1;
    }

    public static void findConnected(int r, int c, char component, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i ++) {
            int nR = r + dR[i];
            int nC = c + dC[i];

            if (nR >= 0 && nR < N && nC >= 0 && nC < M){
                if (!visited[nR][nC] && grid[nR][nC] == grid[r][c]) {
                    findConnected(nR, nC, component, visited);
                }
            }
        }
        grid[r][c] = component;
    }
}
class Cord {
    int r;
    int c;
    int dis;

    public Cord (int first, int second, int third) {
        r = first;
        c = second;
        dis = third;
    }
}
import java.io.*;
import java.util.*;
 
public class SolveTheMaze {
 
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
 
    static int numGood;
    static int numBad;
    static boolean[][] visited;
    static int N;
    static int M;
    static char[][] grid;
    static void main(String[] args) throws IOException {
 
        final int T = Integer.parseInt(r.readLine());
 
        for (int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            grid = new char[N][M];
            int goodPeople = 0;
            for (int row = 0; row < N; row ++) {
 
                grid[row] = r.readLine().toCharArray();
                for (int col = 0; col < M; col++) {
                    if (grid[row][col] == 'G') {
                        goodPeople++;
                    }
                }
            }
            if (checkValid(goodPeople))
                pw.println("Yes");
            else
                pw.println("No");
        }
        pw.close();
    }
    public static boolean checkValid(int goodPeople) {
        visited = new boolean[N][M];
        numGood = 0;
        numBad = 0;
        floodFill(N - 1, M - 1);
 
        numGood = 0;
        numBad = 0;
        visited = new boolean[N][M];
        floodFill(N - 1, M - 1);
 
        if (numGood == goodPeople && numBad == 0)
            return true;
        else
            return false;
    }
 
    public static void floodFill(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M)
            return;
        if (visited[r][c] || grid[r][c] == '#')
            return;
        if (grid[r][c] == 'G')
            numGood++;
        if (grid[r][c] == 'B')
            numBad ++;
        if (checkBad(r,c) && grid[r][c] == '.')
            grid[r][c] = '#';
 
 
        visited[r][c] = true;
 
        floodFill(r + 1, c);
        floodFill(r - 1, c);
        floodFill (r, c + 1);
        floodFill( r, c - 1);
    }
 
    public static boolean checkBad(int r, int c) {
        if (r > 0) {
            if (grid[r - 1][c] == 'B')
                return true;
        }
        if (r < N - 1) {
            if (grid[r + 1][c] == 'B')
                return true;
        }
        if (c > 0) {
            if (grid[r][c - 1] == 'B')
                return true;
        }
        if (c < M - 1) {
            if (grid[r][c + 1] == 'B')
                return true;
        }
        return false;
    }
}
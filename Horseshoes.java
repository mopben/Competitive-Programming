import java.io.*;
import java.util.*;

public class Horseshoes {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static boolean[][] visited;
    static char[][] grid;
    static int N;
    static final int[] disR = {1,-1,0,0};
    static final int[] disC = {0,0,1,-1};
    static int ans;
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("hshoe"));
        PrintWriter pw = new PrintWriter(new FileWriter("hshoe"));
		
        N = Integer.parseInt(r.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i ++) {
            grid[i] = r.readLine().toCharArray();
        }
        visited = new boolean[N][N];

        ans = 0;

        if (grid[0][0] == '(') {
            solve(0,0,1,0,true);
        }
        pw.println(ans);
        pw.close();
    }
    // if cur == true then we're adding open parenthesis
    public static void solve(int row, int col, int open, int closed, boolean cur) {
        if (open == closed) {
            ans = Math.max(ans, open + closed);
            return;
        }
        visited[row][col] = true;

        for (int k = 0; k < 4; k ++) {
            int tempR = row + disR[k];
            int tempC = col + disC[k];
            
            if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N) {
                if (!visited[tempR][tempC]) {
                    
                    if (cur && grid[tempR][tempC] == '(') {
                        solve(tempR, tempC, open + 1, closed, true);
                    }
                    if (cur && grid[tempR][tempC] == ')') {
                        solve(tempR, tempC, open, closed + 1, false);
                    }
                    if (!cur && grid[tempR][tempC] == ')') {
                        solve(tempR, tempC, open, closed + 1, false);
                    }
                }
            }
        }
        visited[row][col] = false;
    }
}
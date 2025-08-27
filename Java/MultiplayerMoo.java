import java.io.*;
import java.util.*;

public class MultiplayerMoo {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int[][] board;
    static boolean[][] visited;
    final static int[] disR = {1,-1,0,0};
    final static int[] disC = {0,0,1,-1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));

        N = Integer.parseInt(r.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans1 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (!visited[i][j]) {
                    ans1 = Math.max(ans1, floodFill(i,j,0,board[i][j],board[i][j]));
                }
            }
        }
        int ans2 = 0;

        loop : for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (ans2 == N * N) {
                    break loop;
                }

                if (j > 0 && board[i][j] != board[i][j - 1]) {
                    visited = new boolean[N][N];
                    ans2 = Math.max(ans2, floodFill(i, j,0, board[i][j], board[i][j-1]));
                }
            }

        }
        pw.println(ans1);
        pw.println(ans2);
        pw.close();
    }


    public static int floodFill(int r, int c, int numConnected, int val, int val2) {
        numConnected ++;
        visited[r][c] = true;

        for (int i = 0; i < 4; i ++) {
            int nextR = r + disR[i];
            int nextC = c + disC[i];

            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
                if (!visited[nextR][nextC] && (board[nextR][nextC] == val || board[nextR][nextC] == val2)) {
                    numConnected = floodFill(nextR, nextC, numConnected, val, val2);
                }
            }
        }
        return numConnected;
    }
}

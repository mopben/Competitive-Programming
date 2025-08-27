import java.io.*;
import java.util.*;

public class MooyoMooyo {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static boolean[][] visited;
    static int N;
    static int K;
    static char[][] board;
    static final int M = 10; //number of rows
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mooyomooyo.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i ++) {
            board[i] = r.readLine().toCharArray();
        }

        for (int t = 0; t < 20; t ++) {
            removeConnected();
            simulateGravity();
        }
        for (char[] i : board) {
            pw.println(new String(i));
        }
        pw.close();
    }
    public static void removeConnected() {

        for (int r = 0; r < N; r ++) {
            for (int c = 0; c < M; c ++) {
				visited = new boolean[N][M];
                if (!visited[r][c] && board[r][c] != '0') {
                    if (findConnected(r,c,0,board[r][c]) >= K) {
                        for (int y = 0; y < N; y ++) {
                            for (int x = 0; x < M; x ++) {
                                if (visited[y][x]) {
                                    board[y][x] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static int findConnected(int r, int c, int connected, char past) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return connected;
        }
        if (visited[r][c] || board[r][c] != past) {
            return connected;
        }
        visited[r][c] = true;
        connected ++;

        connected = findConnected(r+1, c, connected, board[r][c]);
        connected = findConnected(r-1, c, connected, board[r][c]);
        connected = findConnected(r, c+1, connected, board[r][c]);
        connected = findConnected(r, c-1, connected, board[r][c]);

        return connected;
    }
    public static void simulateGravity() {
        for (int c = 0; c < M; c ++) {
            for (int r = N - 1; r >= 0; r --) {
                int lowestZero = -1;
                for (int i = r + 1; i < N; i ++) {
                    if (board[i][c] == '0') {
                        lowestZero = i;
                    }
                }
                if (lowestZero != -1) {
                    board[lowestZero][c] = board[r][c];
                    board[r][c] = '0';
                }
            }
        }
    }
}
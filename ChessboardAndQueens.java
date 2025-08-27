import java.io.*;
import java.util.*;

public class ChessboardAndQueens{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int counter;
    static boolean[][] board;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    public static void main(String[] args) throws IOException {
        board = new boolean[8][8];
        for (int i = 0; i < 8; i ++) {
            char[] temp = r.readLine().toCharArray();
            for (int j = 0; j < 8; j ++) {
                board[i][j] = temp[j] == '*';
            }
        }

        counter = 0;
        col = new boolean[8];
        diag1 = new boolean[15];
        diag2 = new boolean[15];

        solve(0);
        pw.println(counter);
        pw.close();
    }
    public static void solve(int r) {
        if (r == 8)
            counter++;
        else {
            for (int c = 0; c < 8; c++ ) {
                if (!board[r][c] && !diag1[c - r + 7] && !diag2[c + r] && !col[c]) {
                    diag1[c - r + 7] = diag2[c + r] = col[c] = true;
                    solve(r + 1);
                    diag1[c - r + 7] = diag2[c + r] = col[c] = false;

                }
            }
        }
    }
}
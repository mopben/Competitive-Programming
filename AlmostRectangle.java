import java.io.*;
import java.util.*;

public class AlmostRectangle {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            int N = Integer.parseInt(r.readLine());

            int x1 = -1;
            int y1 = -1;
            int x2 = -1;
            int y2 = -1;
            char[][] grid = new char[N][N];
            for (int j = 0; j < N; j ++) {
                grid[j] = r.readLine().toCharArray();
                for (int k = 0; k < N; k ++) {
                    if (grid[j][k] == '*') {
                        if (x1 == -1) {
                            y1 = j;
                            x1 = k;
                        }
                        else {
                            y2 = j;
                            x2 = k;
                        }
                    }
                }
            }
            int x3;
            int y3;
            int x4;
            int y4;
            if (y1 == y2) {
                x3 = x1;
                x4 = x2;

                if (y1 < N-1) {
                    y3 = y1+1;
                    y4 = y1+1;
                }
                else {
                    y3 = y1-1;
                    y4 = y1-1;
                }
            }
            else if (x1 == x2) {
                y3 = y1;
                y4 = y2;

                if (x1 < N-1) {
                    x3 = x1+1;
                    x4 = x1+1;
                }
                else {
                    x3 = x1-1;
                    x4 = x1-1;
                }
            }
            else {
                x3 = x1;
                x4 = x2;
                y3 = y2;
                y4 = y1;
            }

            grid[y3][x3] = '*';
            grid[y4][x4] = '*';

            for (char[] j : grid) {
                pw.println(new String(j));
            }
        }
        pw.close();
    }
}
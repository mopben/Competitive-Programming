import java.io.*;
import java.util.*;

public class ComfortableCowsSilver {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static final int[] dX = {1, -1, 0, 0};
    static final int[] dY = {0, 0, 1, -1};
    static int ans = 0;
    static final int SIZE = 2_000;
    static boolean[][] isCow;
    static int[][] numAdjTo;
    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        isCow = new boolean[SIZE][SIZE];
        numAdjTo = new int[SIZE][SIZE];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;

            ans --; //if there is already a cow placed there, that means that it is an extra cow added
            markAdj(x, y);

            pw.println(ans);
        }
        pw.close();
    }

    public static void markAdj(int x, int y) { // add a 4th cow adjacent to a cow which is adjacent to 3 cows
        if (!isCow[y][x]) {
            ans ++;
            isCow[y][x] = true;

            if (numAdjTo[y][x] == 3) {
                addCow(x, y);
            }
            for (int k = 0; k < 4; k ++) {
                int nX = x + dX[k];
                int nY = y + dY[k];

                numAdjTo[nY][nX] ++;

                if (numAdjTo[nY][nX] == 3 && isCow[nY][nX]) {
                    addCow(nX, nY);
                }
            }

        }
    }
    public static void addCow(int x, int y) {
        for (int k = 0; k < 4; k ++) {
            int nX = x + dX[k];
            int nY = y + dY[k];

            markAdj(nX, nY);
        }
    }
}

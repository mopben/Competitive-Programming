import java.io.*;
import java.util.*;

public class BuildGates {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static boolean[][] notAllowed;
    static final int SIZE = 2001;

    static final int[] disR = {1,-1,0,0};
    static final int[] disC = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("gates.out"));

        int N = Integer.parseInt(r.readLine());

        char[] directions = r.readLine().toCharArray();

        notAllowed = new boolean[SIZE][SIZE];

        int y = SIZE / 2;
        int x = SIZE / 2;
        for (int dir : directions) {
            for (int i = 0; i < 2; i ++) {
                if (dir == 'N')
                    y --;
                if (dir == 'S')
                    y ++;
                if (dir == 'W')
                    x --;
                if (dir == 'E')
                    x ++;
                notAllowed[y][x] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j++) {
                if (!notAllowed[i][j]) {
                    ans ++;
                    floodFill(i, j);
                }
            }
        }
        pw.println(ans - 1);
        pw.close();
    }
    public static void floodFill(int r, int c) {

        Queue<Pair> next = new LinkedList<>();
        next.add(new Pair(r,c));
        notAllowed[r][c] = true;

        while (!next.isEmpty()) {
            r = next.peek().r;
            c = next.poll().c;

            for (int i = 0; i < 4; i ++) {
                int nextR = r + disR[i];
                int nextC = c + disC[i];
                if (nextR >= 0 && nextR < SIZE && nextC >= 0 && nextC < SIZE) {
                    if (!notAllowed[nextR][nextC]) {
                        next.add(new Pair(nextR, nextC));
                        notAllowed[nextR][nextC] = true;
                    }
                }
            }
        }
    }
}
class Pair {
    int r;
    int c;

    public Pair(int first, int second) {
        r = first;
        c = second;
    }
}

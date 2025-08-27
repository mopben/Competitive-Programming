import java.io.*;
import java.util.*;

public class WheresBessie {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static char[][] image;
    static final int[] disR = {1,-1,0,0};
    static final int[] disC = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("where.out"));

        N = Integer.parseInt(r.readLine());

        image = new char[N][N];
        for (int i = 0; i < N; i ++) {
            image[i] = r.readLine().toCharArray();
        }

        ArrayList<Square> PCLs = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                for (int k = i; k < N; k ++) {
                    for (int a = j; a < N; a ++) {
                        if (checkPCL(i,j,k,a)) {
                            PCLs.add(new Square(i,j,k,a));
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (Square i : PCLs) {
            ans += checkValid(PCLs, i);
        }
        pw.println(ans);
        pw.close();
    }
    public static int checkValid(ArrayList<Square> PCLs, Square i) {
        for (Square j : PCLs) {
            if (checkInside(i, j) && !i.equals(j)) {
                return 0;
            }
        }
        return 1;
    }
    public static boolean checkInside(Square i, Square j) {
        return i.x1 >= j.x1 && i.x2 <= j.x2 && i.y1 >= j.y1 && i.y2 <= j.y2;
    }
    public static boolean checkPCL(int x1, int y1, int x2, int y2) {
        boolean[][] visited = new boolean[N][N];
        int[] colors = new int[26];

        for (int r = y1; r <= y2; r ++) {
            for (int c = x1; c <= x2; c ++) {
                if (!visited[r][c]) {
                    colors[image[r][c] - 'A'] ++;
                    floodFill(r, c, visited, y1, y2, x1, x2);
                }
            }
        }

        int numColors = 0;
        boolean foundOne = false;
        boolean foundMoreThanOne = false;

        for (int i : colors) {
            if (i == 1) {
                foundOne = true;
                numColors ++;
            }
            if (i > 1) {
                foundMoreThanOne = true;
                numColors ++;
            }
        }
        return numColors == 2 && foundOne && foundMoreThanOne;
    }

    public static void floodFill(int r, int c, boolean[][] visited, int minR, int maxR, int minC, int maxC) {

        visited[r][c] = true;

        for (int i = 0; i < 4; i ++) {
            int nextR = r + disR[i];
            int nextC = c + disC[i];
            if (nextR >= minR && nextR <= maxR && nextC >= minC && nextC <= maxC) {
                if (!visited[nextR][nextC] && image[nextR][nextC] == image[r][c]) {
                    floodFill(nextR, nextC, visited, minR, maxR, minC, maxC);
                }
            }
        }
    }
}
class Square {
    int x1;
    int y1;
    int x2;
    int y2;

    public Square(int first, int second, int third, int fourth) {
        x1 = first;
        y1 = second;
        x2 = third;
        y2 = fourth;
    }
}
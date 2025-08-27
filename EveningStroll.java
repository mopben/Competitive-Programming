import java.io.*;
import java.util.*;

public class EveningStroll {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int R;
    static int C;
    static char[][] field;
    static int startR = -1;
    static int startC = -1;
    static int endR = -1;
    static int endC = -1;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new char[R][C];


        for (int i = 0; i < R; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < C; j ++) {
                field[i][j] = st.nextToken().charAt(0);
                if (startR == -1 && field[i][j] == 'B') {
                    startR = i;
                    startC = j;
                }
                else if (field[i][j] == 'B') {
                    endR = i;
                    endC = j;
                }
            }
        }

        pw.println(findPaths());
        pw.close();
    }
    public static int findPaths() {
        int[][] paths = new int[R][C];
        Queue<Pair> next = new LinkedList<>();
        next.add(new Pair(endR, endC));
        paths[endR][endC] = 1;

        while (!next.isEmpty()) {
            int row = next.peek().row;
            int col = next.poll().col;

            if (row - 1 >= 0) {
                if (paths[row - 1][col] == 0 && field[row - 1][col] != 'R') {
                    next.add(new Pair(row - 1, col));
                }
                paths[row - 1][col] += paths[row][col];
            }
            if (col - 1 >= 0) {
                if (paths[row][col - 1] == 0 && field[row][col - 1] != 'R') {
                    next.add(new Pair(row, col - 1));
                }
                paths[row][col - 1] += paths[row][col];
            }
        }
        return paths[startR][startC];
    }
}
class Pair {
    int row;
    int col;

    public Pair(int first, int second) {
        row = first;
        col = second;
    }
}

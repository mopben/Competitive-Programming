import java.io.*;
import java.util.*;

public class CornMaze {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i ++) {
            grid[i] = r.readLine().toCharArray();
        }

        Pair[][] slides = new Pair[N][M];
        HashMap<Character, Pair> first = new HashMap<>();
        Pair start = null;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {

                if (grid[i][j] != '@' && grid[i][j] != '#' && grid[i][j] != '.' && grid[i][j] != '=') {
                    if (first.containsKey(grid[i][j])) {
                        Pair pair = first.get(grid[i][j]);
                        slides[i][j] = pair;
                        slides[pair.y][pair.x] = new Pair(j, i);
                    } else {
                        first.put(grid[i][j], new Pair(j, i));
                    }
                }
                if (grid[i][j] == '@') {
                    start = new Pair(j, i);
                }
            }
        }
        assert start != null;

        boolean[][] visited = new boolean[N][M];
        Queue<Pair> next = new LinkedList<>();
        Queue<Integer> dis = new LinkedList<>();

        dis.add(0);
        next.add(new Pair(start.x, start.y));
        while (!next.isEmpty() && !dis.isEmpty()) {
            Pair cord = next.poll();
            int moves = dis.poll();

            if (grid[cord.y][cord.x] == '=') {
                pw.println(moves);
                break;
            }

            for (int i = 0; i < 4; i ++) {
                int nX = cord.x + dX[i];
                int nY = cord.y + dY[i];

                if (nX >= 0 && nX < M && nY >= 0 && nY < N && !visited[nY][nX] && grid[nY][nX] != '#') {
                    if (slides[nY][nX] != null) {
                        next.add(slides[nY][nX]);
                    }
                    else {
                        next.add(new Pair(nX, nY));
                    }
                    visited[nY][nX] = true;
                    dis.add(moves + 1);
                }
            }
        }
        pw.close();
    }
}
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


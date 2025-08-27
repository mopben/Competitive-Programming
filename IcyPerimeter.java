import java.io.*;
import java.util.*;

public class IcyPerimeter{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("perimeter.in"));
            pw = new PrintWriter(new FileWriter("perimeter.out"));

        } catch(IOException e) {}
    }

    static boolean[][] visited;
    static int n;
    static int area;
    static int perimeter;
    static char[][] grid;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(r.readLine());
        grid = new char[n][n];
        for (int i = 0; i < n; i ++)
            grid[i] = r.readLine().toCharArray();

        visited = new boolean[n][n];
        int maxArea = 0;
        int minPerimeter = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j] && grid[i][j] == '#') {
                    area = 0;
                    perimeter = 0;
                    floodFill(i,j);

                    if (area == maxArea && perimeter < minPerimeter)
                        minPerimeter = perimeter;

                    if (area > maxArea) {
                        maxArea = area;
                        minPerimeter = perimeter;
                    }
                }
            }
        }
        pw.println(maxArea + " " + minPerimeter);
        pw.close();
    }
    public static void floodFill(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= n) {
            perimeter ++;
            return;
        }
        if (grid[y][x] == '.') {
            perimeter ++;
            return;
        }
        if (!visited[y][x]) {
            visited[y][x] = true;
            area ++;
            floodFill(y+1,x);
            floodFill(y-1,x);
            floodFill(y,x+1);
            floodFill(y,x-1);
        }
    }
}
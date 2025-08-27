import java.io.*;
import java.util.*;

public class PerimeterBronze {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static boolean[][] visited;
    static boolean[][] occupied;
    static final int SIZE = 102;
    static final int[] disR = {1,-1,0,0};
    static final int[] disC = {0,0,1,-1};
    static int perimeter = 0;
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("perimeter.out"));
		
        int N = Integer.parseInt(r.readLine());

        occupied = new boolean[SIZE][SIZE];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            occupied[row][col] = true;
        }
        visited = new boolean[SIZE][SIZE];
        findPerimeter(0,0);

        pw.println(perimeter);
        pw.close();
    }
    public static void findPerimeter(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (occupied[row][col]) {
            perimeter ++;
            return;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; i ++) {
            findPerimeter(row + disR[i], col + disC[i]);
        }
    }
}
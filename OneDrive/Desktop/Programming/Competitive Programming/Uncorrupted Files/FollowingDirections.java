
import java.io.*;
import java.util.*;

public class FollowingDirections {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    static int totalCost;
    static boolean[][] visited;
    static char[][] direction;
    static int[][] cost;
    static int[][] prev; //number of cows leading into specific cow
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(r.readLine());

        direction = new char[n][n];
        cost = new int[n + 1][n + 1];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            direction[i] = st.nextToken().toCharArray();
            cost[i][n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            cost[n][i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n + 1][n + 1];
        prev = new int[n + 1][n + 1];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j]) {
                    findInitialCost(i, j, 1);
                }
            }
        }
        System.out.println(totalCost);

        int q = Integer.parseInt(r.readLine());
        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(r.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1; //should be x
            int x = Integer.parseInt(st.nextToken()) - 1; //should be y (accidentally switched)
            updateCost(y, x);
            System.out.println(totalCost);
        }
    }

    public static int findInitialCost(int y, int x, int prevNum) {
        visited[y][x] = true;
        prev[y][x] = prevNum;

        if (y >= direction.length || x >= direction.length) {
            prev[y][x] --;
            return cost[y][x];
        }
        if (direction[y][x] == 'R') {
            cost[y][x] = findInitialCost(y, x + 1, prevNum + 1);
        }
        else if (direction[y][x] == 'D') {
            cost[y][x] = findInitialCost(y + 1, x, prevNum + 1);
        }
        totalCost += cost[y][x];
        return cost[y][x];
    }
    public static void updatePrev(int y, int x, int change) {

        if (y >= direction.length || x >= direction.length) {
            return;
        }
        if (direction[y][x] == 'R') {
            prev[y][x + 1] += change;
            updatePrev(y, x + 1, change);
        }
        else if (direction[y][x] == 'D') {
            prev[y + 1][x] += change;
            updatePrev(y + 1, x, change);
        }
    }

    public static void updateCost(int y, int x) {
        if (direction[y][x] == 'R') {
            totalCost -= cost[y][x + 1] * prev[y][x];
            totalCost += cost[y + 1][x] * prev[y][x];
            cost[y][x] = cost[y + 1][x];

            updatePrev(y, x, -prev[y][x]);
            direction[y][x] = 'D';
        }
        else {
            totalCost -= cost[y + 1][x] * prev[y][x];
            totalCost += cost[y][x + 1] * prev[y][x];
            cost[y][x] = cost[y][x + 1];

            updatePrev(y, x, -prev[y][x]);
            direction[y][x] = 'R';
        }
        updatePrev(y, x, prev[y][x]);
    }
}

import java.io.*;
import java.util.*;

public class MoocastGold {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int[][] cows;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));

        N = Integer.parseInt(r.readLine());

        cows = new int[N][2];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        long low = 0; long high = Integer.MAX_VALUE;
        while (low < high) {
            long middle = (low + high) / 2;

            if (checkValid(middle)) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(long budget) {
        double maxDis = Math.sqrt(budget);

        graph = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                if (findDis(i,j) <= maxDis) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        return findVisited(0, new boolean[N]) == N;
    }
    public static int findVisited(int node, boolean[] visited) {
        int numVisited = 1;
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                numVisited += findVisited(i, visited);
            }
        }
        return numVisited;
    }
    public static double findDis(int a, int b) {
        int x1 = cows[a][1]; int y1 = cows[a][0];
        int x2 = cows[b][1]; int y2 = cows[b][0];

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

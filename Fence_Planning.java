import java.io.*;
import java.util.*;

public class Fence_Planning{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, HashSet<Integer>> connections;
    static boolean[] visited;
    static Pair[] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("fenceplan.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cows = new Pair[n];
        connections = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());
            cows[i] = new Pair(x,y);
            connections.put(i, new HashSet<>());
        }

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            final Integer cow1 = Integer.parseInt(st.nextToken()) - 1;
            final Integer cow2 = Integer.parseInt(st.nextToken()) - 1;
            connections.get(cow1).add(cow2);
            connections.get(cow2).add(cow1);
        }
        visited = new boolean[n];

        long ans = 9_999_999_999_999L;
        for (int i = 0; i < n; i ++) {
            Corners corners;
            if (!visited[i]) {
                corners = dfs(i, new Corners(1_000_000_000, 0, 1_000_000_000, 0));
                long perimeter = (corners.maxX - corners.minX) * 2L + (corners.maxY - corners.minY) * 2L;
                ans = Math.min(ans, perimeter);
            }
        }
        pw.println(ans);
        pw.close();
    }
    public static Corners dfs(int node, Corners corners) {
        corners.minX = Math.min(corners.minX,cows[node].x);
        corners.maxX = Math.max(corners.maxX,cows[node].x);
        corners.minY = Math.min(corners.minY, cows[node].y);
        corners.maxY = Math.max(corners.maxY, cows[node].y);

        visited[node] = true;
        for (int i : connections.get(node)) {
            if (!visited[i])
                corners = dfs(i, corners);
        }
        return corners;
    }
}
class Pair {
    int x;
    int y;
    public Pair(int a, int b) {
        x = a;
        y = b;
    }
}
class Corners {
    int minX;
    int maxX;
    int minY;
    int maxY;
    public Corners(int a, int b, int c, int d) {
        minX = a;
        maxX = b;
        minY = c;
        maxY = d;
    }
}
import java.io.*;
import java.util.*;

public class MoocastSilver{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, HashSet<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
        
		int n = Integer.parseInt(r.readLine());
        int[][] cows = new int[n][3];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            cows[i][2] = Integer.parseInt(st.nextToken());
        }
        graph = new HashMap<>();
        for (int i = 0; i < n; i ++)
            graph.put(i,new HashSet<>());

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i != j && getDistance(cows[i][0],cows[i][1],cows[j][0],cows[j][1]) <= cows[i][2])
                    graph.get(i).add(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            visited = new boolean[n];
            ans = Math.max(ans, dfs(i,0));
        }
        pw.println(ans);
        pw.close();
    }
    public static int dfs(int node, int cowsReached) {
        cowsReached ++;
        visited[node] = true;

        for (int i : graph.get(node)) {
            if (!visited[i])
                cowsReached = dfs(i,cowsReached);
        }

        return cowsReached;
    }
    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }
}
import java.io.*;
import java.util.*;

public class CoverIt {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> group1;
    static ArrayList<Integer> group2;
    public static void main(String[] args) throws IOException{

        final int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {

            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new LinkedList[n];

            for (int j = 0; j < n; j ++) {
                graph[j] = new LinkedList<>();
            }

            for (int j = 0; j < m; j ++) {
                st = new StringTokenizer(r.readLine());
                int node1 = Integer.parseInt(st.nextToken()) - 1;
                int node2 = Integer.parseInt(st.nextToken()) - 1;

                graph[node1].add(node2);
                graph[node2].add(node1);
            }
            visited = new boolean[n];
            group1 = new ArrayList<>();
            group2 = new ArrayList<>();

            dfs(1, 1);

            pw.println(Math.min(group1.size(), group2.size()));

            if (group1.size() < group2.size()) {
                for (int j = 0; j < group1.size() - 1; j ++) {
                    pw.print(group1.get(j) + " ");
                }
                pw.println(group1.get(group1.size() - 1));
            }
            else {
                for (int j = 0; j < group2.size() - 1; j ++) {
                    pw.print(group2.get(j) + " ");
                }
                pw.println(group2.get(group2.size() - 1));
            }
        }
        pw.close();
    }
    public static void dfs(int node, int color) {
        if (color == 1) {
            group1.add(node + 1);
        }
        else {
            group2.add(node + 1);
        }
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                dfs(i, 3 - color);
            }
        }
    }
}

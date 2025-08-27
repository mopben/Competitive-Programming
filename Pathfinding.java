import java.io.*;
import java.util.*;

public class Pathfinding {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        int[] dis = new int[N];
        Queue<Integer> next = new LinkedList<>();

        visited[M - 1] = true;
        next.add(M - 1);

        while (!next.isEmpty()) {
            int node = next.poll();
            add(dis[node], node + 1);

            for (int i = 0; i < N; i ++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    next.add(i);
                    visited[i] = true;
                    dis[i] = dis[node] + 1;
                }
            }
        }
        for (List<Integer> i : ans) {
            Collections.sort(i);
            for (int j = 0; j < i.size() - 1; j ++) {
                pw.print(i.get(j) + " ");
            }
            pw.println(i.get(i.size() - 1));
        }
        pw.close();
    }
    static void add(int index, int val) {
        while (ans.size() <= index) {
            ans.add(new ArrayList<>());
        }
        ans.get(index).add(val);
    }
}

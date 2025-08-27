import java.io.*;
import java.util.*;

public class Cowntagion {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static LinkedList<Integer>[] farms;
    static LinkedList<Integer>[] tree;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        farms = new LinkedList[N];
        tree = new LinkedList[N];

        for (int i = 0; i < N; i ++) {
            farms[i] = new LinkedList<>();
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            int farm1 = Integer.parseInt(st.nextToken()) - 1;
            int farm2 = Integer.parseInt(st.nextToken()) - 1;

            farms[farm1].add(farm2);
            farms[farm2].add(farm1);
        }


        visited = new boolean[N];
        buildTree(0);

        visited = new boolean[N];
        solve(0);

        pw.println(ans);
        pw.close();
    }
    public static void buildTree(int node) {
        visited[node] = true;

        for (int farm : farms[node]) {
            if (!visited[farm]) {
                tree[node].add(farm);
                buildTree(farm);
            }
        }
    }
    public static void solve(int node) {
        visited[node] = true;

        if (tree[node].size() > 0) {
            ans += Math.ceil(Math.log(tree[node].size() + 1) / Math.log(2));
        }

        for (int farm : tree[node]) {
            if (!visited[farm]) {
                ans ++;
                solve(farm);
            }
        }
    }
}

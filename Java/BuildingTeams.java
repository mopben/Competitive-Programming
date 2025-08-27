import java.io.*;
import java.util.*;

public class BuildingTeams {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, HashSet<Integer>> friendships = new HashMap<>();
    static boolean[] visited;
    static int[] colors;
    static boolean valid;
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("wormsort.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("wormsort.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i ++)
            friendships.put(i, new HashSet<>());

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            friendships.get(a).add(b);
            friendships.get(b).add(a);
        }
        colors = new int[n];
        visited = new boolean[n];
        valid = true;

        for (int i = 0; i < n; i ++) {
            if (!visited[i])
                dfs(i,1);
        }
        if (!valid)
            pw.println("IMPOSSIBLE");
        else {
            for (int i = 0; i < n; i ++) {
                pw.print(colors[i]);
                if (i < n-1)
                    pw.print(" ");
                else
                    pw.println();
            }
        }
        pw.close();
    }
    public static void dfs(int node, int color) {
        visited[node] = true;
        colors[node] = color;

        for (int i : friendships.get(node)) {
            if (!visited[i])
                dfs(i, 3 - color);
            else if (colors[i] == colors[node])
                valid = false;
        }
    }

}
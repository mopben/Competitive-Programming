import java.io.*;
import java.util.*;

public class ClosingTheFarm {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, HashSet<Integer>> barns;
    static int N;
    static int M;
    static HashSet<Integer> removed;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("closing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("closing.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barns = new HashMap<>();

        for (int i = 0; i < N; i ++) {
            barns.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int barn1 = Integer.parseInt(st.nextToken()) - 1;
            int barn2 = Integer.parseInt(st.nextToken()) - 1;
            barns.get(barn1).add(barn2);
            barns.get(barn2).add(barn1);
        }

        removed = new HashSet<>();

        int[] removedOrder = new int[N];
        for (int i = 0; i < N; i ++) {
            removedOrder[i] = Integer.parseInt(r.readLine()) - 1;
        }

        for (int i = 0; i < N; i ++) {

            if (checkPossible(removedOrder[N-1]))
                pw.println("YES");
            else
                pw.println("NO");

            removed.add(removedOrder[i]);
        }
        pw.close();
    }
    public static boolean checkPossible(int start) {
        boolean[] visited = dfs(start, new boolean[N]);

        for (int i = 0; i < N; i ++) {
            if (!visited[i] && !removed.contains(i))
                return false;
        }
        return true;
    }
    public static boolean[] dfs(int node, boolean[] visited) {
        visited[node] = true;

        for (int i : barns.get(node)) {
            if (!visited[i] && !removed.contains(i))
                dfs(i, visited);
        }
        return visited;
    }
}
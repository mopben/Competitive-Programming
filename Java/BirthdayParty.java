import java.io.*;
import java.util.*;

public class BirthdayParty {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static HashSet<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (p == 0 && c == 0) {
                break;
            }

            adj = new HashSet[p];
            for (int i = 0; i < p; i ++) {
                adj[i] = new HashSet<>();
            }

            for (int i = 0; i < c; i ++) {
                st = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }

            boolean works = true;
            loop : for (int i = 0; i < p; i ++) {
                for (int j = 0; j < p; j ++) {

                    if (adj[i].contains(j)) {
                        visited = new boolean[p];
                        adj[i].remove(j);
                        adj[j].remove(i);
                        if (dfs(0, 0) != p) {
                            works = false;
                            break loop;
                        }
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }

            if (works) {
                pw.println("No");
            }
            else {
                pw.println("Yes");
            }
        }
        pw.close();
    }
    public static int dfs(int node, int numVisited) {
        numVisited ++;
        visited[node] = true;

        for (int i : adj[node]) {
            if (!visited[i]) {
                numVisited = dfs(i, numVisited);
            }
        }
        return numVisited;
    }
}

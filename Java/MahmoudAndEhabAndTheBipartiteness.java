
import java.io.*;
import java.util.*;

public class MahmoudAndEhabAndTheBipartiteness {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static ArrayList<Integer>[] graph;
    static HashSet<Integer> color1;
    static HashSet<Integer> color2;
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        color1 = new HashSet<>();
        color2 = new HashSet<>();
        dfs(0,-1,2);

        long maxSize = (long) color1.size() * color2.size();

        pw.println(maxSize - (N-1));
        pw.close();
    }
    public static void dfs(int node, int last, int color) {
        if (color == 1) {
            color1.add(node);
        }
        else {
            color2.add(node);
        }
        for (int i : graph[node]) {
            if (i != last) {
                dfs(i, node, 3 - color);
            }
        }
    }
}
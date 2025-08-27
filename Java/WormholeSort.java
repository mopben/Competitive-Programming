import java.io.*;
import java.util.*;

public class WormholeSort {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int[][] wormholes;
    static boolean[] swapsNeeded;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("wormsort.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] loc = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            loc[i] = Integer.parseInt(st.nextToken());

        boolean sorted = true;
        swapsNeeded = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (loc[i] != i+1) {
                sorted = false;
                swapsNeeded[i] = true;
            }
        }
        wormholes = new int[m][3];
        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            wormholes[i][0] = Integer.parseInt(st.nextToken());
            wormholes[i][1] = Integer.parseInt(st.nextToken());
            wormholes[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wormholes,Comparator.comparingInt(values -> values[2]));

        if (sorted)
            pw.println(-1);
        else
            pw.println(solve());
        pw.close();

    }
    public static int solve() {
        int left = 0; int right = wormholes.length;
        while (left < right) {
            final int middle = (left + right + 1) / 2;
            if (checkValid(middle))
                left = middle;
            else
                right = middle - 1;
        }
        return wormholes[left][2];
    }

    public static boolean checkValid(int minIndex) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = minIndex; i < m ; i ++) {
            graph.computeIfAbsent(wormholes[i][0], k -> new HashSet<>()).add(wormholes[i][1]);
            graph.computeIfAbsent(wormholes[i][1], k -> new HashSet<>()).add(wormholes[i][0]);
        }

        boolean[] visited = dfs(graph, wormholes[m-1][0], new boolean[n]);
        for (int i = 0; i < n; i ++) {
            if (swapsNeeded[i] && !visited[i])
                return false;
        }
        return true;
    }
    
    public static boolean[] dfs(HashMap<Integer, HashSet<Integer>> graph, int node, boolean[] visited) {
        visited[node - 1] = true;
        for (int i : graph.get(node)) {
            if (!visited[i - 1])
                visited = dfs(graph, i, visited);
        }
        return visited;
    }
}
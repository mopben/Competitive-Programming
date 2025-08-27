import java.io.*;
import java.util.*;

public class ShortestPath {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("mootube.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int NODES = Integer.parseInt(st.nextToken());
        final int EDGES = Integer.parseInt(st.nextToken());
        final int START = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Integer>[] graph = new ArrayList[NODES];
        for (int i = 0; i < NODES; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < EDGES; i ++) {
            st = new StringTokenizer(r.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            graph[node1].add(node2);
        }

        int[] minPaths = new int[NODES];
        Arrays.fill(minPaths, -1);
        boolean[] visited = new boolean[NODES];

        Queue<Integer> next = new LinkedList<>();
        next.add(START);
        minPaths[START] = 0;
        visited[START] = true;

        while (!next.isEmpty()) {
            int node = next.poll();

            for (int i : graph[node]) {
                if (!visited[i]) {
                    next.add(i);
                    visited[i] = true;
                    minPaths[i] = minPaths[node] + 1;
                }
            }
        }
        for (int i = 0; i < NODES; i ++) {
            pw.print(minPaths[i]);

            if (i != NODES - 1) {
                pw.print(" ");
            }
        }
        pw.println();
        pw.close();
    }
}

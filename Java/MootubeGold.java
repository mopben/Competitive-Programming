import java.io.*;
import java.util.*;

public class MootubeGold {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] connections = new int[N][3];
        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(r.readLine());
            connections[i][0] = Integer.parseInt(st.nextToken()) - 1;
            connections[i][1] = Integer.parseInt(st.nextToken()) - 1;
            connections[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(connections, Comparator.comparingInt(value -> value[2]));

        Integer[][] queries = new Integer[Q][3];
        for (int i = 0; i < Q; i ++) {
            st = new StringTokenizer(r.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken()) - 1;
            queries[i][2] = i;
        }
        Arrays.sort(queries, Comparator.comparingInt(values -> values[0]));
        Collections.reverse(Arrays.asList(queries));

        DisjointSet graph = new DisjointSet(N);
        int index = N - 1;
        int[] ans = new int[Q];
        for (int i = 0; i < Q; i ++) {
            while (connections[index][2] >= queries[i][0]) {
                graph.union(connections[index][0], connections[index][1]);
                index --;
            }
            ans[queries[i][2]] = graph.getSize(queries[i][1]) - 1;
        }
        for (int i : ans) {
            pw.println(i);
        }
        pw.close();
    }
}
class DisjointSet {
    int[] parents;
    int[] sizes;


    public DisjointSet(int size) {
        sizes = new int[size];
        parents = new int[size];
        Arrays.fill(sizes, 1);
        Arrays.fill(parents, -1);
    }

    public int getSize(int node) {
        return sizes[find(node)];
    }

    public int find(int node) {
        return parents[node] == -1 ? node : (parents[node] = find(parents[node]));
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (sizes[xRoot] < sizes[yRoot]) {
            parents[xRoot] = yRoot;
            sizes[yRoot] += sizes[xRoot];
        }
        else {
            parents[yRoot] = xRoot;
            sizes[xRoot] += sizes[yRoot];
        }
    }
}

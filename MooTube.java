import java.io.*;
import java.util.*;

public class MooTube {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static List<Edge>[] adj;
    static int videosSuggested;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());

        adj = new List[N];
        for (int i = 0; i < N; i ++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(r.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            adj[first].add(new Edge(second, weight));
            adj[second].add(new Edge(first, weight));
        }
        for (int i = 0; i < Q; i ++) {
            st = new StringTokenizer(r.readLine());
            int minWeight = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) - 1;

            videosSuggested = 0;
            findVideos(start, -1, minWeight);
            pw.println(videosSuggested - 1);
        }
        pw.close();
    }
    public static void findVideos(int node, int prev, int minWeight) {
        videosSuggested ++;
        for (Edge i : adj[node]) {
            if (i.node != prev && i.weight >= minWeight)
                findVideos(i.node, node, minWeight);
        }
    }
}
class Edge {
    int node;
    int weight;
    public Edge(int first, int second) {
        node = first;
        weight = second;
    }
    @Override
    public String toString() {
        return ("(" + node + "," + weight + ")");
    }
}


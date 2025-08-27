import java.io.*;
import java.util.*;

public class Subordinates {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
    static int[] children;
    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(r.readLine());

        for (int i = 0; i < N; i ++)
            adj.put(i, new HashSet<>());

        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i < N; i ++) {
            adj.get(Integer.parseInt(st.nextToken()) - 1).add(i);
        }

        children = new int[N];
        findChildren(0);

        for (int i = 0; i < N; i ++) {
            if (i == N - 1)
                pw.println(children[i] - 1);
            else
                pw.print(children[i] - 1 + " ");
        }
        pw.close();
    }
    public static int findChildren(int node) {
        children[node] = 1;

        for(int i : adj.get(node))
            children[node] += findChildren(i);

        return children[node];
    }
}

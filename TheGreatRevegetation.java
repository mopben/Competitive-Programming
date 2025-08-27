import java.io.*;
import java.util.*;

public class TheGreatRevegetation {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static HashMap<Integer, ArrayList<List<Integer>>> pastures;
    static boolean[] visited;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        pastures = new HashMap<>();
        for (int i = 0; i < n; i ++)
            pastures.put(i, new ArrayList<>());

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            int diet = st.nextToken().equals("S") ? 1 : 2; //S is 1, D is 2
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            pastures.get(a).add(Arrays.asList(b, diet));
            pastures.get(b).add(Arrays.asList(a, diet));
        }

        int ans = 0;
        visited = new boolean[n];
        colors = new int[n];
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                if (dfs(i, true, 1))
                    ans ++;
            }
        }
        if (ans == 0)
            pw.println(0);
        else {
            pw.print(1);
            for (int i = 0; i < ans; i ++)
                pw.print(0);
            pw.println();
        }
        pw.close();
    }
    static boolean dfs(int node, boolean valid, int color) {
        visited[node] = true;
        colors[node] = color;

        for (List<Integer> i : pastures.get(node)) {
            final int node2 = i.get(0);
            final int diet2 = i.get(1);

            if (!visited[node2] && diet2 == 1)
                valid = dfs(node2, valid, color);
            if (!visited[node2] && diet2 == 2)
                valid = dfs(node2,valid , 3 - color);

            else if (diet2 == 1 && colors[node2] != colors[node])
                valid = false;
            else if (diet2 == 2 && colors[node2] == colors[node] && colors[node] != 0)
                valid = false;
        }
        return valid;
    }
}
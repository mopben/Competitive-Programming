import java.io.*;
import java.util.*;

public class FlightRoutesCheck {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("mootube.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] flights = new ArrayList[N];
        ArrayList<Integer>[] flights2 = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            flights[i] = new ArrayList<>();
            flights2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int city1 = Integer.parseInt(st.nextToken()) - 1;
            int city2 = Integer.parseInt(st.nextToken()) - 1;
            flights[city1].add(city2);
            flights2[city2].add(city1);
        }

        visited = new boolean[N];
        if (dfs(0,0,flights) == N) {

            visited = new boolean[N];
            if (dfs(0,0,flights2) == N) {
                pw.println("YES");
            }

            else {
                pw.println("NO");
                for (int i = 0; i < N; i ++) {
                    if (!visited[i]) {
                        int temp = i + 1;
                        pw.println(temp + " " + i);
                    }
                }
            }
        }
        else {
            pw.println("NO");
            for (int i = 0; i < N; i ++) {
                if (!visited[i]) {
                    int temp = i + 1;
                    pw.println(i + " " + temp);
                }
            }
        }
        pw.close();


    }
    public static int dfs(int node, int counter, ArrayList<Integer>[] graph) {
        counter ++;
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                counter = dfs(i, counter, graph);
            }
        }
        return counter;
    }
}


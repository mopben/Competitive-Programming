import java.io.*;
import java.util.*;

public class ClockTree {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> group1 = new ArrayList<>();
    static ArrayList<Integer> group2 = new ArrayList<>();
    static int[] clockNum;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("clocktree.out"));

        int N = Integer.parseInt(r.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            graph[i] = new ArrayList<>();
        }

        clockNum = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            clockNum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i ++) {
            st = new StringTokenizer(r.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        visited = new boolean[N];
        dfs(0,2);

        int sum1 = group1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = group2.stream().mapToInt(Integer::intValue).sum();

        if (sum1 % 12 == sum2 % 12) {
            pw.println(group1.size() + group2.size());
        }
        else if ((sum1 + 1) % 12 == sum2 % 12) {
            pw.println(group2.size());
        }
        else if (sum1 % 12 == (sum2 + 1) % 12) {
            pw.println(group1.size());
        }
        else {
            pw.println(0);
        }
        pw.close();
    }
    public static void dfs(int node, int color) {
        if (color == 1) {
            group1.add(clockNum[node]);
        }
        else {
            group2.add(clockNum[node]);
        }
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                dfs(i, 3 - color);
            }
        }
    }
}
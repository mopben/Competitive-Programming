import java.io.*;
import java.util.*;

public class BuildingRoads{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static boolean[] visited;
    static int n;
    static ArrayList<Integer>[] roads;
    static ArrayList<Integer> connectedCities;
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("test.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("test.out"))
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            int city1 = Integer.parseInt(st.nextToken()) - 1;
            int city2 = Integer.parseInt(st.nextToken()) - 1;
            roads[city1].add(city2);
            roads[city2].add(city1);
        }
        connectedCities = new ArrayList<>();
        visited = new boolean[n+1];
        int roadsRequired = countComponents() - 1;

        pw.println(roadsRequired);
        for (int i = 0; i < roadsRequired; i ++) {
            int temp = connectedCities.get(i) + 1;
            int temp2 = connectedCities.get(i + 1) + 1;
            pw.println(temp + " " + temp2);
        }
        pw.close();
    }
    public static void dfs(int node) {
        visited[node] = true;
        for (int i : roads[node]) {
            if (!visited[i])
                dfs(i);
        }
    }
    public static int countComponents() {
        int counter = 0;
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                counter ++;
                connectedCities.add(i);
                dfs(i);
            }
        }
        return counter;
    }
}
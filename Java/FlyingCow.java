import java.io.*;
import java.util.*;

public class FlyingCow {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[] dis = new int[N + 4];
        boolean[] visited = new boolean[N + 4];
        Queue<Integer> next = new LinkedList<>();

        next.add(1);
        visited[1] = true;
        while (!next.isEmpty()) {
            int loc = next.poll();
            if (loc == N) {
                pw.println(dis[loc]);
                break;
            }

            if (loc * 3 < dis.length && !visited[loc * 3]) {
                next.add(loc * 3);
                visited[loc * 3] = true;
                dis[loc * 3] = dis[loc] + 1;
            }
            if (loc + 1 < dis.length && !visited[loc + 1]) {
                next.add(loc + 1);
                visited[loc + 1] = true;
                dis[loc + 1] = dis[loc] + 1;
            }
            if (loc - 1 >= 0 && !visited[loc - 1]) {
                next.add(loc - 1);
                visited[loc - 1] = true;
                dis[loc - 1] = dis[loc] + 1;
            }
        }
        pw.close();
    }
}

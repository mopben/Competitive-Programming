import java.io.*;
import java.util.*;

public class PaintJob {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] paints = new int[N];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            paints[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> next = new LinkedList<>();
        boolean[] visited = new boolean[P + 1];
        int[] dis = new int[P + 1];

        next.add(A);
        visited[A] = true;
        boolean found = false;
        while (!next.isEmpty()) {
            int color = next.poll();

            if (color == B) {
                found = true;
                pw.println(dis[color]);
                break;
            }
            for (int paint : paints) {
                int nextColor = (color * paint) % P;
                if (!visited[nextColor]) {
                    next.add(nextColor);
                    visited[nextColor] = true;
                    dis[nextColor] = dis[color] + 1;
                }
            }
        }
        if (!found) {
            pw.println(-1);
        }
        pw.close();
    }
}

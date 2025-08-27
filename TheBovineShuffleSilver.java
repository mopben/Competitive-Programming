import java.io.*;
import java.util.*;

public class TheBovineShuffleSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));

        final int N = Integer.parseInt(r.readLine());

        int[] parents = new int[N];
        int[] next = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            next[i] = Integer.parseInt(st.nextToken()) - 1;
            parents[next[i]] ++;
        }
        int ans = N;

        Queue<Integer> parentless = new LinkedList<>();
        for (int i = 0; i < N; i ++) {
            if (parents[i] == 0) {
                parentless.add(i);
                ans --;
            }
        }

        while (!parentless.isEmpty()) {
            int pos = parentless.poll();

            if (--parents[next[pos]] == 0) {
                parentless.add(next[pos]);
                ans --;
            }
        }
        pw.println(ans);
        pw.close();
    }
}

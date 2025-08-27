import java.io.*;
import java.util.*;

public class AcowdemiaII {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> members = new HashMap<>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            members.put(st.nextToken(),i);
        }

        char[][] ans = new char[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (i == j)
                    ans[i][j] = 'B';
                else
                    ans[i][j] = '?';
            }
        }

        for (int i = 0; i < K; i ++) {
            String[] paper = new String[N];
            st = new StringTokenizer(r.readLine());

            for (int j = 0; j < N; j ++)
                paper[j] = st.nextToken();

            for (int j = 0; j < N; j ++) {
                boolean alphabetical = true;
                for (int a = j + 1; a < N; a ++) {
                    if (paper[a-1].compareTo(paper[a]) > 0) {
                        alphabetical = false;
                    }

                    if (!alphabetical) {
                        int x = members.get(paper[j]);
                        int y = members.get(paper[a]);
                        ans[x][y] = '0';
                        ans[y][x] = '1';
                    }
                }
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                pw.print(ans[i][j]);
            }
            pw.println();
        }
        pw.close();
    }
}

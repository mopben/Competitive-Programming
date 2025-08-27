import java.io.*;
import java.util.*;

public class CowGymnastics {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] rank = new int[k][n];
        for (int i = 0; i < k; i ++) {
            st = new StringTokenizer(r.readLine());

            for (int j = 0; j < n; j ++) {
                int ranking = Integer.parseInt(st.nextToken()) - 1;
                rank[i][ranking] = j;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i+1; j < n; j ++) {
                boolean better = false;
                if (rank[0][i] < rank[0][j])
                    better = true;

                boolean works = true;
                for (int a = 1; a < k; a ++) {
                    if (better && rank[a][i] > rank[a][j]) {
                        works = false;
                        break;
                    }
                    if (!better && rank[a][i] < rank[a][j]) {
                        works = false;
                        break;
                    }
                }
                if (works)
                    ans ++;
            }
        }
        pw.println(ans);
        pw.close();

    }
}

import java.io.*;
import java.util.*;

public class DinnerTime {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] tables = new int[M][2];
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            tables[i][0] = Integer.parseInt(st.nextToken());
            tables[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[] used = new boolean[N];

        for (int i = 0; i < M; i ++) {
            double minDis = Double.MAX_VALUE;
            int closestCow = 0;
            for (int j = 0; j < N; j ++) {
                if (!used[j]) {
                    double dis = findDis(tables[i][1], tables[i][0], cows[j][1], cows[j][0]);
                    if (dis < minDis) {
                        minDis = dis;
                        closestCow = j;
                    }
                }
            }
            used[closestCow] = true;
        }
        for (int i = 0; i < N; i ++) {
            if (!used[i]) {
                pw.println(i + 1);
            }
        }
        if (M >= N) {
            pw.println(0);
        }
        pw.close();
    }
    public static double findDis(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
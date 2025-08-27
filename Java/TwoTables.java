import java.io.*;
import java.util.*;

public class TwoTables {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        final int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            final int W = Integer.parseInt(st.nextToken());
            final int H = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(r.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(r.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int ans = Integer.MAX_VALUE;

            if (x2 - x1 + w <= W) {
                ans = Math.min(ans, Math.min(Math.max(0, w - x1), Math.max(0, x2 - (W - w))));
            }

            if (y2 - y1 + h <= H) {
                ans = Math.min(ans, Math.min(Math.max(0, h - y1), Math.max(0, y2 - (H - h))));
            }


            if (ans != Integer.MAX_VALUE) {
                pw.println((double) ans);
            }
            else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}

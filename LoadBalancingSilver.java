import java.io.*;
import java.util.*;

public class LoadBalancingSilver{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("balancing.in"));
            pw = new PrintWriter(new FileWriter("balancing.out"));

        } catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        int[][] cows = new int[n][2];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, Comparator.comparingInt(value -> value[0]));
        //solve------------------------------------------------------------------------------------------------------
        int ans = 1_001;
        for (int i = 0; i < n; i ++) {
            int hor = cows[i][1] - 1;
            int northEast = 0; int northWest = 0; int southEast = 0; int southWest = 0;
            for (int j = 0; j < n; j ++) {
                if (cows[j][1] > hor)
                    northEast ++;
                else
                    southEast ++;
            }
            ans = Math.min(ans,Math.max(northEast, Math.max(northWest,Math.max(southEast,southWest))));

            for (int j = 0; j < n; j ++) {
                if (cows[j][1] > hor) {
                    northWest ++;
                    northEast --;
                }
                else {
                    southWest ++;
                    southEast --;
                }
                ans = Math.min(ans,Math.max(northEast, Math.max(northWest,Math.max(southEast,southWest))));
            }
        }
        pw.println(ans);
        pw.close();
    }
}

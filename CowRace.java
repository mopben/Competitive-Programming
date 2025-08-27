import java.io.*;
import java.util.*;

public class CowRace {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static final int MAX_SIZE = 1_000_000;
    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(r.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[] bessie = new int[MAX_SIZE];
        int curTime = 0;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            int speed = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for (int j = curTime; j < curTime + time; j ++) {
                bessie[j] = speed;
            }
            curTime += time;
        }

        int[] elsie = new int[MAX_SIZE];
        curTime = 0;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int speed = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for (int j = curTime; j < curTime + time; j ++) {
                elsie[j] = speed;
            }
            curTime += time;
        }

        int ans = 0;

        boolean wasLeaderBessie = false;
        boolean wasLeaderElsie = false;
        int bessieLoc = 0;
        int elsieLoc = 0;
        for (int i = 0; i < MAX_SIZE; i ++) {
            bessieLoc += bessie[i];
            elsieLoc += elsie[i];

            if (!wasLeaderBessie && !wasLeaderElsie && bessieLoc != elsieLoc) {
                wasLeaderElsie = elsieLoc > bessieLoc;
                wasLeaderBessie = bessieLoc > elsieLoc;
            }
            if (bessieLoc > elsieLoc && !wasLeaderBessie) {
                wasLeaderBessie = true;
                wasLeaderElsie = false;
                ans ++;
            }
            if (elsieLoc > bessieLoc && !wasLeaderElsie) {
                wasLeaderElsie = true;
                wasLeaderBessie = false;
                ans ++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}

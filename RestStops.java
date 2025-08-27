import java.io.*;
import java.util.*;

public class RestStops {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(r.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int rF = Integer.parseInt(st.nextToken());
        int rB = Integer.parseInt(st.nextToken());

        int[][] stops = new int[N][2];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            stops[i][0] = Integer.parseInt(st.nextToken());
            stops[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stops, Comparator.comparingInt(value -> value[0]));

        List<Pair> bestStops = new ArrayList<>();
        int max = 0;
        for (int i = N - 1; i >= 0; i --) {
            if (stops[i][1] > max) {
                bestStops.add(new Pair(stops[i][0], stops[i][1]));
                max = stops[i][1];
            }
        }
        Collections.reverse(bestStops);

        long ans = 0;
        int pastLoc = 0;
        for (Pair p : bestStops) {
            int dis = p.loc - pastLoc;
            long timeApart = ((long) rF * dis) - ((long) rB * dis);
            ans += p.tastiness * timeApart;

            pastLoc = p.loc;
        }
        pw.println(ans);
        pw.close();
    }
}
class Pair {
    int loc;
    int tastiness;

    public Pair(int loc, int tastiness) {
        this.loc = loc;
        this.tastiness = tastiness;
    }
}
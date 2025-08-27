import java.io.*;
import java.util.*;

public class Wormholes {


    static int n;
    static int[][] wormholes;
    static boolean[] visited;
    static int[] adj;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));

        n = Integer.parseInt(r.readLine());

        wormholes = new int[n][2];

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            wormholes[i][0] = Integer.parseInt(st.nextToken());
            wormholes[i][1] = Integer.parseInt(st.nextToken());
        }


        adj = new int[n];

        Arrays.fill(adj, -1);

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (wormholes[i][1] == wormholes[j][1] && wormholes[i][0] < wormholes[j][0] && (adj[i] == -1 || wormholes[adj[i]][0] - wormholes[i][0] > wormholes[j][0] - wormholes[i][0])) {
                    adj[i] = j;
                }
            }
        }
        int[] pairs = new int[n];
        Arrays.fill(pairs, -1);

        generatePermutations(pairs);

        pw.println(ans);
        pw.close();
    }
    public static void generatePermutations(int[] pairs) {

        int unpaired = -1;
        for (int i = 0; i < n; i ++) {
            if (pairs[i] == -1) {
                unpaired = i;
                break;
            }
        }
        if (unpaired == -1) {
            if (detectCycleHelper(pairs)) {
                ans ++;
            }
        }
        for (int j = unpaired + 1; j < n; j ++) {
            if (pairs[j] == -1) {
                pairs[unpaired] = j;
                pairs[j] = unpaired;
                generatePermutations(pairs);
                pairs[unpaired] = -1;
                pairs[j] = -1;
            }
        }
    }
    public static boolean detectCycleHelper(int[] pairs) {

        for (int i = 0; i < n; i ++) {
            int pos = i;
            for (int j = 0; j < n; j ++) {
                pos = adj[pairs[pos]];
                if (pos == -1) {
                    break;
                }
            }
            if (pos != -1) {
                return true;
            }
        }

        return false;
    }
}

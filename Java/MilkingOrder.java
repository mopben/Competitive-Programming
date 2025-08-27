import java.io.*;
import java.util.*;

public class MilkingOrder {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milkorder.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] hierarchy = new int[M + 2];
        boolean foundCow1 = false;
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= M; i ++) {
            int cow = Integer.parseInt(st.nextToken());
            hierarchy[i] = cow;

            if (cow == 1) {
                foundCow1 = true;
            }
        }

        boolean[] spotTaken = new boolean[N];
        int[] pos = new int[N + 2];

        Arrays.fill(pos, -1);

        for (int i = 0; i < K; i ++) {
            st = new StringTokenizer(r.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken()) - 1;

            pos[cow] = loc;
            spotTaken[loc] = true;
        }

        if (foundCow1) { //cow 1 is in hierarchy
            for (int i = 1; i <= M; i ++) {
                if (pos[hierarchy[i]] == -1) {
                    for (int j = pos[hierarchy[i - 1]] + 1; j < N; j ++) { // place cow in earliest possible spot
                        if (!spotTaken[j]) {
                            spotTaken[j] = true;
                            pos[hierarchy[i]] = j;
                            break;
                        }
                    }
                }
            }
        }
        else { //cow 1 is NOT in hierarchy
            for (int i = M - 1; i >= 1; i --) {
                if (pos[hierarchy[i]] == -1) {
                    for (int j = pos[hierarchy[i + 1]] - 1; j >= 0; j --) { // place cow in earliest possible spot
                        if (!spotTaken[j]) {
                            spotTaken[j] = true;
                            pos[hierarchy[i]] = j;
                            break;
                        }
                    }
                }
            }
        }
        int ans = -1;

        if (pos[1] != -1) {
            ans = pos[1] + 1;
        }
        else {
            for (int i = 0; i < N; i ++) {
                if (!spotTaken[i]) {
                    ans = i + 1;
                    break;
                }
            }
        }

        pw.println(ans);
        pw.close();
    }
}
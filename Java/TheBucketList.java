import java.io.*;
import java.util.*;

public class TheBucketList {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int[][] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blist.out"));

        N = Integer.parseInt(r.readLine());

        cows = new int[N*2][3];
        for (int i = 0; i < N*2; i += 2) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int lockersUsed = Integer.parseInt(st.nextToken());
            cows[i][0] = start;
            cows[i][1] = lockersUsed;
            cows[i][2] = 1;
            cows[i+1][0] = end;
            cows[i+1][1] = lockersUsed;
            cows[i+1][2] = -1;
        }
        Arrays.sort(cows, Comparator.comparingInt(value -> value[0]));

        int low = 0; int high = 1_000_000_000;
        while (low < high) {
            int middle = (low + high) / 2;
            if (checkValid(middle))
                high = middle;
            else
                low = middle + 1;
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(int lockers) {
        int lockersUsed = 0;
        for (int i = 0; i < N * 2; i ++) {
            lockersUsed += (cows[i][1]  * cows[i][2]);
            if (lockersUsed > lockers)
                return false;
        }
        return true;
    }
}
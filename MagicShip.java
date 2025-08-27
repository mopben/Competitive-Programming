import java.io.*;
import java.util.*;

public class MagicShip {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static long n;
    static int[][] sums;
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("berries.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("berries.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(r.readLine());

        sums = new int[(int) (n+1)][2];
        char[] weather = r.readLine().toCharArray();
        for (int i = 1; i <= n; i ++) {
            if (weather[i - 1] == 'U')
                sums[i][1] = sums[i-1][1] + 1;
            if (weather[i - 1] == 'D')
                sums[i][1] = sums[i-1][1] - 1;
            if (weather[i - 1] == 'L')
                sums[i][0] = sums[i-1][0] - 1;
            if (weather[i - 1] == 'R')
                sums[i][0] = sums[i-1][0] + 1;
        }
        pw.println(binarySearch());
        pw.close();
    }
    public static long binarySearch() {
        long low = 0; long high = Long.MAX_VALUE / 2;

        long ans = -1;
        while (low <= high) {
            final long middle = (low + high) / 2;
            if (checkValid(middle, x1, y1)) {
                ans = middle;
                high = middle;
            }
            else
                low = middle;
        }
        return ans;
    }

    public static boolean checkValid(long days, long x, long y) {
        x += (sums[(int) n][0]) * (days / n) + (sums[(int) (days % n)][0]);
        y += (sums[(int) n][1]) * (days / n) + (sums[(int) (days % n)][1]);
        long movesNeeded = Math.abs(x - x2) + Math.abs(y - y2);
        return movesNeeded <= days;
    }
}


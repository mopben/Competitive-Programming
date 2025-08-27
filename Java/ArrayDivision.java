import java.io.*;
import java.util.*;

public class ArrayDivision {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int[] arr;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("cardgame.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        pw.println(binarySearch());
        pw.close();

    }
    public static long binarySearch() {
        long left = 0; long right = Long.MAX_VALUE;
        while (left < right) {
            long middle = (left + right) / 2;

            if (checkPossible(middle))
                right = middle;
            else
                left = middle + 1;
        }
        return right;
    }
    public static boolean checkPossible(long x) {
        ArrayList<Long> sums = new ArrayList<>();
        sums.add(0L);
        for (int i = 0; i < n; i ++) {
            int index = sums.size() - 1;
            if (sums.get(index) + arr[i] > x)
                sums.add(0L);

            index = sums.size() - 1;
            sums.set(index, sums.get(index) + arr[i]);
        }
        long maxVal = 0;
        for (Long i : sums)
            maxVal = Math.max(i,maxVal);

        return maxVal <= x && sums.size() <= k;
    }
}
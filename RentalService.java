import java.io.*;
import java.util.*;

public class RentalService{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("rental.in"));
            pw = new PrintWriter(new FileWriter("rental.out"));

        } catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] cows = new Integer[n];
        for (int i = 0; i < n; i ++)
            cows[i] = Integer.parseInt(r.readLine());

        int[][] stores = new int[m][2];
        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(r.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());
            stores[i][1] = Integer.parseInt(st.nextToken());
        }
        Integer[] farmers = new Integer[k];
        for (int i = 0; i < k; i ++)
            farmers[i] = Integer.parseInt(r.readLine());

        Arrays.sort(farmers,Collections.reverseOrder());

        int[] rental = new int[k+1];
        for (int i = 1; i <= k; i ++)
            rental[i] = rental[i-1] + farmers[i-1];

        Arrays.sort(cows,Collections.reverseOrder());
        Arrays.sort(stores,Comparator.comparingInt(a -> -a[1]));
        // solve------------------------------------------
        long[] profits = new long[n+1];
        int index = 0;
        for (int i = 0; i < n; i ++) {
            profits[i+1] = profits[i];

            while (index < m && cows[i] > 0) {
                int sold = Math.min(cows[i],stores[index][0]);
                profits[i+1] += (long) stores[index][1] * sold;
                cows[i] -= sold;
                stores[index][0] -= sold;

                if (stores[index][0] == 0)
                    index ++;
            }
        }
        index = n -1;
        int rI = 0;
        long counter = 0;
        while (index >= 0 && rI < k) {
            counter += farmers[rI];
            profits[index] += counter;
            rI ++;
            index --;
        }
        long ans = 0;
        for (long i : profits)
            ans = Math.max(ans,i);

        pw.println(ans);
        pw.close();
    }
}

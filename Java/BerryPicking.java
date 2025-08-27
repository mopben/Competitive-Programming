import java.io.*;
import java.util.*;

public class BerryPicking {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("berries.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("berries.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] berries = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            berries[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(berries);
        int ans = 0;
        for (int i = 1; i <= berries[n-1]; i ++) {
            int counter = 0;
            PriorityQueue<Integer> baskets = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int j = 0; j < n; j ++) {
                if (i < berries[j]) {
                    int berriesLeft = berries[j];
                    while (berriesLeft - i >= 0) {
                        baskets.add(i);
                        berriesLeft -= i;
                    }
                    baskets.add(berriesLeft);
                }
                else
                    baskets.add(berries[j]);
            }
            for (int j = 0; j < k / 2; j ++)
                baskets.poll();

            for (int j = 0; j < k / 2; j ++) {
                if (!baskets.isEmpty())
                    counter += baskets.poll();
            }
            ans = Math.max(counter, ans);
        }
        pw.println(ans);
        pw.close();
    }
}
import java.io.*;
import java.util.*;

public class PairedUp {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pairup.out"));

        int N = Integer.parseInt(r.readLine());

        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows, Comparator.comparingInt(value -> value[1]));

        int low = 0;
        int high = N-1;

        int maxTime = 0;
        while (low < high) {

            if (cows[high][0] == 0) {
                high --;
            }
            else if (cows[low][0] == 0) {
                low ++;
            }

            else {
                maxTime = Math.max(maxTime, cows[high][1] + cows[low][1]);
                int amountMinus = Math.min(cows[low][0], cows[high][0]);
                cows[low][0] -= amountMinus;
                cows[high][0] -= amountMinus;
            }
        }
        pw.println(maxTime);
        pw.close();
    }
}

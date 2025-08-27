import java.io.*;
import java.util.*;

public class SleepyCowHerding {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("herding.out"));
		
        final int N = Integer.parseInt(r.readLine());

        int[] cows = new int[N];

        for (int i = 0; i < N; i ++) {
            cows[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(cows);

        int minMoves = Integer.MAX_VALUE;

        if ((cows[1] - cows[0] > 2 && cows[N - 1] - cows[1] == N - 2) || (cows[N - 1] - cows[N - 2] > 2 && cows[N - 2] - cows[0] == N - 2)) {
            minMoves = 2;
        }
        else {
            int j = 0;
            for (int i = 0; i < N; i ++) {
                while (j + 1 < N && cows[j + 1] - cows[i] < N) {
                    j ++;
                }
                minMoves = Math.min(minMoves, N - (j - i + 1));
            }
        }

        int maxMoves = Math.max(cows[N - 2] - cows[0], cows[N - 1] - cows[1]) - (N - 2);

        pw.println(minMoves);
        pw.println(maxMoves);
        pw.close();
    }
}

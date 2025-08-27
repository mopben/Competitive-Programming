import java.io.*;
import java.util.*;

public class StuckInARutSilver {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());

        int[] x = new int[n];
        int[] y = new int[n];
        ArrayList<Integer> east = new ArrayList<>();
        ArrayList<Integer> north = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            char dir = st.nextToken().charAt(0);
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            if (dir == 'E')
                east.add(i);
            else
                north.add(i);
        }
        east.sort(Comparator.comparingInt(i -> y[i]));
        north.sort(Comparator.comparingInt(i -> x[i]));

        boolean[] stopped = new boolean[n];
        int[] amountStopped = new int[n];

        for (int i : east) {
            for (int j : north) {
                if (x[i] < x[j] && y[i] > y[j] && !stopped[i] && !stopped[j]) {
                    if (x[j] - x[i] < y[i] - y[j]) {
                        stopped[j] = true;
                        amountStopped[i] += amountStopped[j] + 1;
                    }
                    else if (x[j] - x[i] > y[i] - y[j]){
                        stopped[i] = true;
                        amountStopped[j] += amountStopped[i] + 1;
                    }
                }
            }
        }
        for (int i : amountStopped) {
            pw.println(i);
        }
        pw.close();
    }
}

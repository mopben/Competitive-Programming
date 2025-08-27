import java.io.*;
import java.util.*;

public class AngryCowsSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int K;
    static int[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        loc = new int[N];
        for (int i = 0; i < N; i ++) {
            loc[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(loc);

        int low = 0; int high = 1_000_000_000;
        while (low < high) {
            int mid = (low + high) / 2;

            if (checkValid(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkValid(int power) {
        int cowsUsed = 0;
        int lastBlast = -1_000_000_000;
        for (int i = 0; i < N; i ++) {
            if (loc[i] - lastBlast > power) {
                cowsUsed ++;
                lastBlast = loc[i] + power;
            }
        }
        return cowsUsed <= K;
    }
}
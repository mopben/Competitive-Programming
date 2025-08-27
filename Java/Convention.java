
import java.io.*;
import java.util.*;

public class Convention{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int M;
    static int C;
    static int[] arrivals;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("convention.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("convention.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arrivals = new int[N];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++)
            arrivals[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrivals);

        int low = 0; int high = 1_000_000_001;
        while (low < high) {
            int mid = (low + high) / 2;
            if (checkPossible(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        pw.println(high);
        pw.close();

    }
    public static boolean checkPossible(int maxWaitingTime) {
        int arrivalTime = 1_000_000_001;
        int bussesLeft = M;
        int cowsLoaded = 0;
        for (int i = 0; i < N; i ++) {

            if (arrivals[i] - arrivalTime > maxWaitingTime || cowsLoaded >= C) {
                arrivalTime = arrivals[i];
                bussesLeft --;
                cowsLoaded = 1;
            }
            else {
                cowsLoaded++;
            }
            if (bussesLeft <= 0) {
                return false;
            }
        }
        return true;
    }
}

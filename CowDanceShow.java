import java.io.*;
import java.util.*;

public class CowDanceShow {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static int maxT;
    static int[] durations;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowdance.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        maxT = Integer.parseInt(st.nextToken());

        durations = new int[n];
        for (int i = 0; i < n; i ++)
            durations[i] = Integer.parseInt(r.readLine());

        pw.println(findMinCowsDancing());
        pw.close();
    }
    public static int findMinCowsDancing() {
        int left = -1; int right = n + 1;
        while (left < right) {
            final int middle = (left + right) / 2;
            if (checkValid(middle))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public static boolean checkValid(int cowsDancing) {
        int timeTaken = 0;
        PriorityQueue<Integer> nextSwap = new PriorityQueue<>();

        for (int i = 0; i < cowsDancing; i ++)
            nextSwap.add(durations[i]);

        for (int i = cowsDancing; i < n; i ++) {
            timeTaken += Math.max(0,nextSwap.poll() - timeTaken);
            nextSwap.add(durations[i] + timeTaken);
        }
        for (int i : nextSwap)
            timeTaken += Math.max(0,i - timeTaken);

        return timeTaken <= maxT;
    }
}
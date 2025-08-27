import java.io.*;
import java.util.*;

public class Race {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("race.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i ++) {
            int maxSpeed = Integer.parseInt(r.readLine());
            pw.println(findMinTime(maxSpeed, K));
        }
        pw.close();
    }
    public static int findMinTime(int maxSpeed, int length) {
        int time = 0;
        int disUp = 0;
        int disDown = 0;

        for (int speed = 1;; speed ++) {
            disUp += speed;
            time ++;

            if (disUp + disDown >= length) {
                return time;
            }
            if (speed >= maxSpeed) {
                time ++;
                disDown += speed;
                if (disUp + disDown >= length) {
                    return time;
                }
            }
        }
    }
}

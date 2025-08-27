import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoadIISilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] signals = new int[N];
        Arrays.fill(signals,1);
        for (int i = 0; i < B; i ++) {
            int damagedSignal = Integer.parseInt(r.readLine()) - 1;
            signals[damagedSignal] = 0;
        }
        int[] sums = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            sums[i+1] = sums[i] + signals[i];
        }
        int ans = N;
        for (int i = 1; i <= N - K + 1; i ++) {
            ans = Math.min(ans, K - (sums[i + K - 1] - sums[i - 1]));
        }
        
        pw.println(ans);
        pw.close();
    }
}
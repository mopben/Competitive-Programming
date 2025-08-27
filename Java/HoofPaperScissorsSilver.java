import java.io.*;
import java.util.*;

public class HoofPaperScissorsSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hps.out"));

        final int N = Integer.parseInt(r.readLine());

        int[] hoof = new int[N+1];
        int[] paper = new int[N+1];
        int[] scissors = new int[N+1];

        for (int i = 1; i <= N; i ++) {
            char gesture = r.readLine().charAt(0);
            paper[i] = paper[i - 1];
            hoof[i] = hoof[i - 1];
            scissors[i] = scissors[i - 1];

            if (gesture == 'H') {
                hoof[i] ++;
            }
            if (gesture == 'P') {
                paper[i] ++;
            }
            if (gesture == 'S') {
                scissors[i] ++;
            }
        }

        int ans = 0;
        for (int i = 0; i <= N; i ++) {
            int before = Math.max(hoof[i] - hoof[0], Math.max(paper[i] - paper[0], scissors[i] - scissors[0]));
            int after = Math.max(hoof[N] - hoof[i], Math.max(paper[N] - paper[i], scissors[N] - scissors[i]));
            ans = Math.max(ans, before + after);
        }
        pw.println(ans);
        pw.close();
    }
}
import java.io.*;
import java.util.*;

public class MeetAndGreet {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static final int MAX_STEPS = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("greetings.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("greetings.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] movements1 = new int[MAX_STEPS + 1];

        int index = 0;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            int steps = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().charAt(0) == 'L' ? -1 : 1;

            for (int j = 0; j < steps; j ++) {
                movements1[index + 1] = movements1[index] + dir;
                index ++;
            }
        }
        for (int i = index; i < MAX_STEPS; i ++) {
            movements1[i + 1] = movements1[i];
        }

        int[] movements2 = new int[MAX_STEPS + 1];

        index = 0;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int steps = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().charAt(0) == 'L' ? -1 : 1;

            for (int j = 0; j < steps; j ++) {
                movements2[index + 1] = movements2[index] + dir;
                index ++;
            }
        }
        for (int i = index; i < MAX_STEPS; i ++) {
            movements2[i + 1] = movements2[i];
        }

        movements1[0] = -1;
        movements2[0] = -1;
        int ans = 0;
        for (int t = 1; t < MAX_STEPS; t ++) {
            if (movements1[t] == movements2[t] && movements1[t - 1] != movements2[t - 1]) {
                ans ++;
            }

        }
        pw.println(ans);
        pw.close();
    }
}

import java.io.*;
import java.util.*;

public class Payback {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int farthest = -1;
        int ans = 0;
        int balance = 0;
        for (int i = 0; i < N + 1; i ++) {
            if (i != N) {
                ans ++;
                balance += Integer.parseInt(r.readLine());
            }
            if (balance >= 0 && farthest != -1) {
                ans += (i - farthest) * 2;
                farthest = -1;
            }
            else if (farthest == -1 && balance < 0) {
                farthest = i;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
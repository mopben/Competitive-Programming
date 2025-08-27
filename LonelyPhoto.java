import java.io.*;
import java.util.*;

public class LonelyPhoto {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());
        int[] guernseys = new int[n + 1];
        int[] holsteins = new int[n + 1];

        char[] photo = r.readLine().toCharArray();
        for (int i = 0; i < n; i ++) {
            guernseys[i + 1] = guernseys[i];
            holsteins[i + 1] = holsteins[i];
            if (photo[i] == 'G') {
                guernseys[i + 1] ++;
            }
            else {
                holsteins[i + 1] ++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = i + 2; j <= n; j ++) {
                if (guernseys[j] - guernseys[i - 1] == 1) {
                    ans ++;
                }
                else if (holsteins[j] - holsteins[i - 1] == 1) {
                    ans ++;
                }int
            }
        }
        pw.println(ans);
        pw.close();
    }
}

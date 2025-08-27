import java.io.*;
import java.util.*;

public class PalindromeReorder {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        char[] str = r.readLine().toCharArray();

        long[] amount = new long[26];
        for (int i = 0; i < str.length; i ++) {
            amount[str[i] - 65] ++;
        }
        
        int odds = 0;
        for (int i = 0; i < 26; i ++) {
            if (amount[i] % 2 == 1) {
                odds ++;
            }
        }
        if (odds > 1) {
            pw.println("NO SOLUTION");
        }

        else {
            StringBuilder ans = new StringBuilder();
            int odd = -1;

            for (int i = 0; i < 26; i ++) {
                for (int j = 0; j < amount[i] / 2; j ++) {
                    ans.append((char) (i + 65));
                }
                if (amount[i] % 2 == 1) {
                    odd = i + 65;
                }
            }
            pw.print(ans);
            if (odd != -1) {
                pw.print((char) odd);
            }
            ans.reverse();
            pw.println(ans);
        }
        pw.close();
    }
}

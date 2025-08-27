import java.io.*;
import java.util.*;

public class A-BPalindrome {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            final int LENGTH = a + b;

            char[] str = r.readLine().toCharArray();

            for (int j = 0; j < LENGTH; j ++) {
                if (str[j] == '0')
                    a --;
                if (str[j] == '1')
                    b --;
            }

            boolean printed = false;
            for (int j = 0; j < LENGTH / 2; j ++) {
                if (str[j] != '?' && str[j] != str[LENGTH - j - 1]) {
                    if (str[LENGTH - j - 1] != '?') {
                        pw.println(-1);
                        printed = true;
                        break;
                    }
                    else {
                        if (str[j] == '0')
                            a --;
                        else
                            b --;
                        str[LENGTH - j - 1] = str[j];
                    }

                }
                else if (str[LENGTH - j - 1] != '?' && str[LENGTH - j - 1] != str[j]) {
                    if (str[j] != '?') {
                        pw.println(-1);
                        printed = true;
                        break;
                    }
                    else {
                        if (str[LENGTH - j - 1] == '0')
                            a --;
                        else
                            b --;
                        str[j] = str[LENGTH - j - 1];
                    }
                }
            }
            for (int j = 0; j < LENGTH / 2; j ++) {
                if (str[j] == '?') {
                    str[j] = str[LENGTH - j - 1] = Math.max(a,b) == a ? '0' : '1';

                    if (str[j] == '0') {
                        a -= 2;
                    }
                    else {
                        b -= 2;
                    }
                }
            }
            if (LENGTH % 2 == 1 && str[LENGTH / 2] == '?') {
                if (a > b) {
                    str[LENGTH / 2] = '0';
                    a --;
                }
                else {
                    str[LENGTH / 2] = '1';
                    b --;
                }
            }

            if (!printed) {
                if (a != 0 || b != 0) {
                    pw.println(-1);
                }
                else {
                    pw.println(new String(str));
                }
            }
        }
        pw.close();
    }
}
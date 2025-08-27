/*
ID: benqia51
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;
public class combo{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("combo.in"));
            pw = new PrintWriter(new FileWriter("combo.out"));

        } catch(IOException e) {}
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] john = new int[3];
        st = new StringTokenizer(r.readLine());
        john[0] = Integer.parseInt(st.nextToken());
        john[1] = Integer.parseInt(st.nextToken());
        john[2] = Integer.parseInt(st.nextToken());

        int[] master = new int[3];
        st = new StringTokenizer(r.readLine());
        master[0] = Integer.parseInt(st.nextToken());
        master[1] = Integer.parseInt(st.nextToken());
        master[2] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i < n+1; i ++) {
            for (int j = 1; j < n+1; j ++) {
                for (int k = 1; k < n+1; k ++) {
                    if ((Math.abs(i - john[0]) <= 2 || Math.abs(i - john[0]) >= n - 2) && (Math.abs(j - john[1]) <= 2 || Math.abs(j - john[1]) >= n - 2) && (Math.abs(k - john[2]) <= 2 || Math.abs(k - john[2]) >= n - 2))
                        ans ++;

                    else if ((Math.abs(i - master[0]) <= 2 || Math.abs(i - master[0]) >= n - 2) && (Math.abs(j - master[1]) <= 2 || Math.abs(j - master[1]) >= n - 2) && (Math.abs(k - master[2]) <= 2 || Math.abs(k - master[2]) >= n - 2))
                        ans ++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
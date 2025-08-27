/*
ID: benqia51
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.StringTokenizer;

public class skidesign{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("skidesign.in"));
            pw = new PrintWriter(new FileWriter("skidesign.out"));

        } catch(IOException e) {}
    }

     
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] hills = new int[n];
        for (int i = 0; i < n; i ++ ) {
            st = new StringTokenizer(r.readLine());
            hills[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 999999999;
        for (int i = 0; i < 83; i ++) {
            int cost = 0;
            for (int j = 0; j < n; j ++) {
                if (hills[j] <= i)
                    cost += (i - hills[j]) * (i - hills[j]);
                if (hills[j] >= i + 17)
                    cost += (hills[j] - (i + 17)) * (hills[j] - (i + 17));
            }
            ans = Math.min(cost,ans);
        }
        pw.println(ans);
        pw.close();
    }
}

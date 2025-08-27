/*
ID: benqia51
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

public class barn1{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("barn1.in"));
            pw = new PrintWriter(new FileWriter("barn1.out"));

        } catch(IOException e) {}
    }
    

    static int s;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[] stalls = new boolean[s];

        for (int i = 0; i < c; i ++) {
            st = new StringTokenizer(r.readLine());
            stalls[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        boolean[] blocked = new boolean[s];
        int start = 999999999;
        int end = 0;

        for (int i = 0; i < s; i ++) {
            if (stalls[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        for (int i = start; i < end+1; i ++)
            blocked[i] = true;

        for (int i = 1; i < m; i ++) {
            int[] temp = findGap(stalls, blocked);
            for (int j = temp[0]; j < temp[1]; j ++)
                blocked[j] = false;
        }
        int ans = 0;
        for (int i = 0; i < s; i ++) {
            if (blocked[i])
                ans++;
        }
        pw.println(ans);
        pw.close();
    }

    public static int[] findGap(boolean[] stalls, boolean[] blocked) {
        int biggestGap = 0;
        int curStart = -1;
        int counter = 0;
        int start = 0;
        for (int i = 0; i < s; i ++){
            if (!stalls[i] && blocked[i])
                counter ++;
            else {
                if (counter > biggestGap && curStart != -1) {
                    biggestGap = counter;
                    start = curStart;
                }
                curStart = i;
                counter = 0;
            }
        }
        if (counter > biggestGap && curStart != -1) {
            biggestGap = counter;
            start = curStart;
        }
        return new int[]{start, start + biggestGap};
    }
}
/*
ID: benqia51
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;

import static java.util.Comparator.comparingInt;

public class milk{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("milk.in"));
            pw = new PrintWriter(new FileWriter("milk.out"));

        } catch(IOException e) {}
    }
    


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] prices = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            prices[i][0] = Integer.parseInt(st.nextToken());
            prices[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(prices, comparingInt(a -> a[0]));
        int minCost = 0;
        for (int i = 0; i < m; i ++) {
            minCost += Math.min(n * prices[i][0], prices[i][1] * prices[i][0]);
            n -= Math.min(n , prices[i][1]);
            if (n == 0)
                break;
        }
        pw.println(minCost);
        pw.close();
    }
}
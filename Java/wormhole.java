/*
ID: benqia51
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;
public class wormhole{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("wormhole.in"));
            pw = new PrintWriter(new FileWriter("wormhole.out"));

        } catch(IOException e) {}
    }

     
    static int[][] holes;
    static int n;
    static HashMap<Integer, Integer> right;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        holes = new int[n][2];
        for (int i = 0; i < n ; i ++) {
            st = new StringTokenizer(r.readLine());
            holes[i][0] = Integer.parseInt(st.nextToken());
            holes[i][1] = Integer.parseInt(st.nextToken());
        }


        right = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)  {
                if (holes[i][1] == holes[j][1] && holes[i][0] < holes[j][0]) {
                    if (!right.containsKey(i))
                        right.put(i,j);
                    else if (holes[j][0] < holes[right.get(i)][0])
                        right.put(i,j);
                }
            }
        }
        int[] temp = new int[n];
        Arrays.fill(temp,-1);
        pw.println(solve(temp));
        pw.close();
    }

    public static int solve(int[] paired) {
        int lastI = 0;
        int total = 0;
        for (int i = 0; i < n; i ++) {
            if (paired[i] == -1)
                break;
            lastI ++;
        }
        if (lastI == n && checkCycle(paired))
            return 1;

        else if (lastI == n)
            return 0;


        for (int j = lastI + 1; j < n; j ++) {
            if (paired[j] == -1) {
                paired[lastI] = j;
                paired[j] = lastI;
                total += solve(paired);
                paired[lastI] = paired[j] = -1;
            }
        }
        return total;
    }

    static boolean checkCycle(int[] paired) {
        for (int i = 0; i < n; i++) {
            int pos = i;
            boolean stopped = false;
            for (int j = 0; j < n; j ++) {
                if (right.containsKey(paired[pos]))
                    pos = right.get(paired[pos]);
                else {
                    stopped = true;
                    break;
                }
            }
            if (!stopped)
                return true;
        }
        return false;
    }
}

/*
ID: benqia51
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("ariprog.in"));
            pw = new PrintWriter(new FileWriter("ariprog.out"));

        } catch(IOException e) {}
    }

     
    static HashSet<Integer> viable;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int m = Integer.parseInt(st.nextToken());

        viable = new HashSet<>();
        boolean[] bisquares = new boolean[(m * m * 2) + 1];
        for (int i = 0; i < m + 1; i ++) {
            for (int j = 0; j < m + 1; j ++) {
                viable.add(i * i + j * j);
                bisquares[i * i + j * j] = true;
            }
        }

        List<int[]> ans = new ArrayList<>();
        for (int i : viable) {
            for (int j = 1; j <= ((m * m * 2) - i) / (n - 1); j ++) {
                boolean invalid = false;
                for (int k = 1; k < n; k ++) {
                    if (!bisquares[i + j * k]) {
                        invalid = true;
                        break;
                    }
                }
                if (!invalid) {
                    ans.add(new int[]{i,j});
                }
            }
        }
        ans.sort(Comparator.comparingInt(a -> a[0]));
        ans.sort(Comparator.comparingInt(a -> a[1]));
        if (ans.isEmpty())
            pw.println("NONE");
        else {
            for (int[] i : ans)
                pw.println(i[0] + " " + i[1]);
        }
        System.out.println(System.nanoTime());
        pw.close();
    }
}

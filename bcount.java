import java.io.*;
import java.util.*;

public class bcount{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("bcount.in"));
            pw = new PrintWriter(new FileWriter("bcount.out"));

        } catch(IOException e) {}
    }

     

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] breed1 = new int[n+1];
        int[] breed2 = new int[n+1];
        int[] breed3 = new int[n+1];

        for (int i = 1; i <= n; i ++) {
            int breed = Integer.parseInt(r.readLine());
            breed1[i] = breed1[i-1]; breed2[i] = breed2[i-1]; breed3[i] = breed3[i-1];

            if (breed == 1)
                breed1[i] ++;
            if (breed == 2)
                breed2[i] ++;
            if (breed == 3)
                breed3[i] ++;
        }

        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
            pw.println((breed1[end] - breed1[start - 1]) + " " + (breed2[end] - breed2[start - 1]) + " " + (breed3[end] - breed3[start - 1]));
        }
        pw.close();
    }
}
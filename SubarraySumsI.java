import java.io.*;
import java.util.*;

public class SubarraySumsI {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("fenceplan.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("fenceplan.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long[] numbers = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;
        long sum = 0;
        long ans = 0;
        while (i < n && j < n ) {
            if (sum == x)
                ans ++;

            if (sum + numbers[j] <= x) {
                sum += numbers[j];
                j ++;
            }
            else if (i != n-1){
                i ++;
                sum -= numbers[i-1];
            }
        }
        if (sum == x)
            ans ++;
        pw.println(ans);
        pw.close();
    }
}
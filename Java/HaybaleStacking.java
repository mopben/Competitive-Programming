import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("test.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("test.out"))
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dif = new int[n+1];
        for (int i = 0; i < k; i ++) {
            st = new StringTokenizer(r.readLine());

            dif[Integer.parseInt(st.nextToken())-1] ++;
            dif[Integer.parseInt(st.nextToken())] --;
        }
        int sum = 0;
        int[] bales = new int[n];
        for (int i = 0; i < n; i ++ ) {
            sum += dif[i];
            bales[i] = sum;
        }
        Arrays.sort(bales);
        pw.println(bales[n/2]);
        pw.close();
    }
}
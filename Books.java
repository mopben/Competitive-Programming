import java.io.*;
import java.util.*;

public class Books {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("fenceplan.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("fenceplan.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] books = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            books[i] = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;
        int ans = 0;
        int counter = 0;
        int sum = 0;
        while (i < n && j < n) {
            if (sum + books[j] <= t) {
                sum += books[j];
                j ++;
                counter ++;
            }
            else {
                sum -= books[i];
                i ++;
                counter --;
            }
            ans = Math.max(counter, ans);
        }
        pw.println(ans);
        pw.close();
    }
}
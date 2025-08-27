import java.io.*;
import java.util.*;

public class Blue-RedPermutation {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(r.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> blue = new ArrayList<>();
            ArrayList<Integer> red = new ArrayList<>();

            char[] colors = r.readLine().toCharArray();
            for (int j = 0; j < n; j ++) {
                char color = colors[j];
                if (color == 'B') {
                    blue.add(arr[j]);
                }
                else {
                    red.add(arr[j]);
                }
            }
            Collections.sort(blue);
            Collections.sort(red);
            Collections.reverse(red);

            int index = 0;
            boolean works = true;
            for (int pos : blue) {
                if (pos < index + 1) {
                    works = false;
                }
                index ++;
            }
            index = 0;
            for (int pos : red) {
                if (pos > n - index) {
                    works = false;
                }
                index ++;
            }

            if (works) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }

        }
        pw.close();
    }
}
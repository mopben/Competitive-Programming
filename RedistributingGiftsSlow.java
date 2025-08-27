
import java.io.*;
import java.util.*;

public class RedistributingGiftsSlow {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int[] ans;
    static int n;
    static int[] loc;
    static int[][] wish;
    public static void main(String[] args) throws IOException { //note: everything is 1-indexed

        n = Integer.parseInt(r.readLine());

        loc = new int[n + 1];
        wish = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++) { // i loops from 1-n
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 1; j <= n; j ++) { // j loops from 1-n
                wish[i][j] = Integer.parseInt(st.nextToken());

                if (wish[i][j] == i) {
                    loc[i] = j;
                }
            }
        }

        ans = new int[n];

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = i + 1;
        }

        solve(arr, 0, n - 1);

        for (int i = 0; i < n; i ++) {
            pw.println(ans[i]);
        }

        pw.close();

    }
    public static void solve(int[] arr, int l, int r) {
        if (l == r) {
            for (int i = 1; i <= n; i++) {
                if (locOf(arr[i - 1], i) > loc[i]) {
                    return;
                }
            }
            for (int i = 1; i <= n; i ++) {
                if (ans[i - 1] == 0 || locOf(ans[i - 1], i) > locOf(arr[i - 1], i)) {
                    ans[i - 1] = arr[i - 1];
                }
            }
        }
        else {
            for (int i = l; i <= r; i ++) {
                swap(arr, l, i);
                solve(arr, l + 1, r);
                swap(arr, l, i);
            }
        }
    }
    public static void swap(int[] arr, int l, int i) {
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;

    }
    public static int locOf(int x, int index) {
        for (int i = 1; i <= n; i ++) {
            if (wish[index][i] == x) {
                return i;
            }
        }
        return -1;
    }

}
import java.io.*;
import java.util.*;

public class SwapitySwapitySwap {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] original = new int[N];
        for (int i = 0; i < N; i ++) {
            original[i] = i + 1;
        }

        int[] swapped = original.clone();
        
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            reverse(swapped, start, end);
        }

        int[] ans = original.clone();
        while (k > 0) {
            if (k % 2 == 1) {
                ans = swap(ans, swapped);
            }
            k /= 2;
            if (k > 0) {
                swapped = swap(swapped, swapped);
            }
        }
        for (int i : ans) {
            pw.println(i);
        }
        pw.close();
    }
    public static int[] swap (int[] original, int[] other) {
        int[] res = new int[N];
        for (int i = 0; i < N; i ++) {
            res[i] = original[other[i] - 1];
        }
        return res;
    }
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
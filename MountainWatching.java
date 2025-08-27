import java.io.*;
import java.util.*;

public class MountainWatching {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[] heights = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            heights[i] = Integer.parseInt(r.readLine());
        }

        boolean increasing = true;
        int ans = 0;

        for (int i = 0; i < N; i ++) {
            if (heights[i+1] > heights[i]) {
                increasing = true;
            }
            if (increasing && heights[i + 1] < heights[i]) {
                int left = i;
                while (left > 0 && heights[left] >= heights[left - 1]) {
                    left --;
                }
                int right = i;
                while (right < N - 1 && heights[right] >= heights[right + 1]) {
                    right ++;
                }
                ans = Math.max(ans, right - left + 1);
                increasing = false;
            }
            else if (i == N - 1) {
                int peak = i;
                while (peak > 0 && heights[peak] >= heights[peak + 1]) {
                    peak --;
                }
                int left = peak;
                while (left > 0 && heights[left] >= heights[left - 1]) {
                    left --;
                }

                ans = Math.max(ans, i - left + 1);
            }
        }
        pw.println(ans);
        pw.close();
    }
}
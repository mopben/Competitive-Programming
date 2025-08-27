import java.io.*;
import java.util.*;

public class AirCownditioning {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(r.readLine());

        int[] preference = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            preference[i] = Integer.parseInt(st.nextToken());
        }

        int[] current = new int[n];
        int[] required = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            current[i] = Integer.parseInt(st.nextToken());
            required[i] = preference[i] - current[i];
        }

        int ans = 0;
        while (true) {
            int bestValue = 0;
            int start = 0;
            int end = 0;
            int change = 0;
            int times = 0;

            int[][] additionValue = new int[n][n + 1];
            int[][] subtractionValue = new int[n][n + 1];
            for (int i = 0; i < n; i ++) {
                int minTimesAdd = Integer.MAX_VALUE;
                int minTimesSub = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    additionValue[i][j + 1] = additionValue[i][j];
                    subtractionValue[i][j + 1] = subtractionValue[i][j];

                    if (required[j] > 0) {
                        additionValue[i][j + 1]++;
                        subtractionValue[i][j + 1]--;
                        minTimesAdd = Math.min(minTimesAdd, required[j]);
                    }
                    else if (required[j] < 0){
                        additionValue[i][j + 1]--;
                        subtractionValue[i][j + 1]++;
                        minTimesSub = Math.min(minTimesSub, Math.abs(required[j]));
                    }
                    else {
                        additionValue[i][j + 1]--;
                        subtractionValue[i][j + 1]--;
                    }
                    if (Math.max(additionValue[i][j + 1], subtractionValue[i][j + 1]) > bestValue) {
                        bestValue = Math.max(additionValue[i][j + 1], subtractionValue[i][j + 1]);
                        start = i;
                        end = j;
                        change = bestValue == additionValue[i][j + 1] ? -1 : 1;
                        times = bestValue == additionValue[i][j + 1] ? minTimesAdd : minTimesSub;
                    }
                }
            }

            if (bestValue == 0) {
                break;
            }
            else {
                for (int i = start; i <= end; i ++) {
                    required[i] += change * times;
                }
                ans += times;
            }
        }
        pw.println(ans);
        pw.close();
    }
}


import java.io.*;
import java.util.*;

public class GroupingIncreases {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());

        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(r.readLine());

            StringTokenizer st = new StringTokenizer(r.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int penalty = 0;
            int lastS = Integer.MAX_VALUE;
            int lastT = Integer.MAX_VALUE;

            for (int next : arr) {
                if (next <= lastS || next <= lastT) {
                    if (lastS >= lastT) {
                        lastS = next;
                    }
                    else {
                        lastT = next;
                    }
                }
                else {
                    if (lastS <= lastT) {
                        lastS = next;
                    }
                    else {
                        lastT = next;
                    }
                    penalty ++;
                }
            }
            System.out.println(penalty);
        }
    }
}

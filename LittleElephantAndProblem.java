import java.io.*;
import java.util.*;

public class LittleElephantAndProblem {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());

        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        if (testWorks(arr, sortedArr)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
    public static boolean testWorks(int[] arr, int[] sortedArr) {
        int wrongLoc = -1;
        int wrongNum = -1;
        boolean switched = false;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] != sortedArr[i]) {
                if (switched) {
                    return false;
                }
                else if (wrongLoc == -1) {
                    wrongNum = arr[i];
                    wrongLoc = i;
                }
                else if (sortedArr[i] == wrongNum && sortedArr[wrongLoc] == arr[i]) {
                    switched = true;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
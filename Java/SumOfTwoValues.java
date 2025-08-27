import java.io.*;
import java.util.*;

public class SumOfTwoValues{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("pairup.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("pairup.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i + 1;
        }

        int left = 0;
        int right = N - 1;
        boolean ansFound = false;

        Arrays.sort(arr, Comparator.comparingInt(value -> value[0]));
        while (left < N && right >= 0) {

            int sum = arr[left][0] + arr[right][0];

            if (sum == X && left != right) {
                pw.println(arr[left][1] + " " + arr[right][1]);
                ansFound = true;
                break;
            }

            if (sum > X) {
                right --;
            }
            else {
                left++;
            }
        }
        if (!ansFound)
            pw.println("IMPOSSIBLE");
        pw.close();
    }
}



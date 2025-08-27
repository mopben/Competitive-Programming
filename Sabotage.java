import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Sabotage {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int N;
    static int[] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("sabotage.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("sabotage.out"));

        N = Integer.parseInt(r.readLine());

        cows = new int[N];
        for (int i = 0; i < N; i ++) {
            cows[i] = Integer.parseInt(r.readLine());
        }

        double low = 1; double high = 10_000;
        for (int i = 0; i < 100; i ++) {
            double middle = (low + high) / 2;

            if (checkValid(middle)) {
                high = middle;
            }
            else {
                low = middle;
            }
        }

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMinimumFractionDigits(3);

        pw.println(df.format(low));
        pw.close();

    }
    public static boolean checkValid(double average) {
        double sum = 0;
        for (int i = 0; i < N; i ++) {
            sum += cows[i] - average;
        }

        return maxSubArraySum(average) >= sum;
    }

    public static double maxSubArraySum(double minusAmount) {
        double maxSum = cows[1] - minusAmount;
        double curSum = 0;

        for (int i = 2; i < N - 1; i ++) {
            curSum = Math.max(0, curSum + cows[i] - minusAmount);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}

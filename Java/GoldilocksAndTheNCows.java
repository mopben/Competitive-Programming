import java.io.*;
import java.util.*;

public class GoldilocksAndTheNCows {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("milktemp.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milktemp.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int[][] cows = new int[N * 2][2];
        for (int i = 0; i < N * 2; i += 2) {
            st = new StringTokenizer(r.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = 0; //0 is start, 1 is end
            cows[i + 1][0] = Integer.parseInt(st.nextToken());
            cows[i + 1][1] = 1;
        }
        Arrays.sort(cows, Comparator.comparingInt(value -> value[1]));
        Arrays.sort(cows, Comparator.comparingInt(value -> value[0]));

        int ans = N * X;
        int curMilk = N * X;
        for (int i = 0; i < N * 2; i ++) {
            if (cows[i][1] == 0) {
                curMilk += (Y - X);
            }
            else {
                curMilk += (Z - Y);
            }
            ans = Math.max(ans, curMilk);
        }
        ans = Math.max(ans, N * Z);
        pw.println(ans);
        pw.close();
    }
}
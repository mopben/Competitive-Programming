import java.io.*;
import java.util.*;

public class TheMeetingPlaceCannotBeChanged{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static int[] loc;
    static int[] speed;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(r.readLine());

        loc = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            loc[i] = Integer.parseInt(st.nextToken());

        speed = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            speed[i] = Integer.parseInt(st.nextToken());


        double low = 0; double high = Math.pow(10, 9);
        for (int i = 0; i < 100; i ++) {
            double middle = (low + high) / 2;
            if (checkPossible(middle))
                high = middle;
            else
                low = middle;
        }
        pw.println(high);
        pw.close();
    }
    public static boolean checkPossible(double time) {
        double min = loc[0] - (speed[0] * time);
        double max = loc[0] + (speed[0] * time);

        for (int i = 1; i < n; i ++) {
            double lowerBound = loc[i] - (speed[i] * time);
            double upperBound = loc[i] + (speed[i] * time);

            if (lowerBound > max || upperBound < min)
                return false;

            min = Math.max(min, lowerBound);
            max = Math.min(max, upperBound);
        }
        return true;
    }
}

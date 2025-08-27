import java.io.*;
import java.util.*;

public class RestaurantCustomers {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        int[][] events = new int[N*2][2];

        for (int i = 0; i < N*2; i += 2) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = 1;
            events[i + 1][0] = Integer.parseInt(st.nextToken());
            events[i + 1][1] = -1;
        }
        Arrays.sort(events, Comparator.comparingInt(value -> value[0]));

        int ans = 0; //ans is the max amount of customers that are there at the same time
        int customersPresent = 0;

        for (int i = 0; i < N * 2; i ++) {
            customersPresent += events[i][1];
            ans = Math.max(ans, customersPresent);
        }
        pw.println(ans);
        pw.close();
    }
}
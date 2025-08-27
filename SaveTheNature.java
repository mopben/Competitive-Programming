import java.io.*;
import java.util.*;

public class SaveTheNature {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static Integer[] tickets;
    static int x;
    static int a;
    static int y;
    static int b;
    static long k;
    public static void main(String[] args) throws IOException {

        final int Q = Integer.parseInt(r.readLine());

        for (int i = 0; i < Q; i ++) {
            final int N = Integer.parseInt(r.readLine());

            tickets = new Integer[N];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j ++) {
                tickets[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tickets, Collections.reverseOrder());

            st = new StringTokenizer(r.readLine());
            x = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(r.readLine());
            y = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            k = Long.parseLong(r.readLine());

            int low = 0; int high = N;
            while (low < high) {
                int mid = (low + high) / 2;

                if (checkValid(mid)) {
                    high = mid;
                }
                else {
                    low = mid + 1;
                }
            }
            if (!checkValid(high)) {
                pw.println(-1);
            }
            else {
                pw.println(high);
            }
        }
        pw.close();
    }
    public static boolean checkValid(int maxTickets) {
        int[] contributions = new int[maxTickets];
        for (int i = 1; i <= maxTickets; i ++) {
            if (i % a == 0) {
                contributions[i - 1] += x;
            }
            if (i % b == 0) {
                contributions[i - 1] += y;
            }
        }
        Arrays.sort(contributions);

        long contribution = 0;
        Iterator<Integer> ticket = Arrays.stream(tickets).iterator();
        for (int i = maxTickets - 1; i >= 0; i --) {
            contribution += ticket.next() * (contributions[i] / 100.0);
        }
        return contribution >= k;
    }
}


import java.io.*;
import java.util.*;

public class Bakery {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static long cTime;
    static long mTime;
    static long[] minCookies;
    static long[] minCookiesMuffins;
    static long[] minMuffins;
    static long[] minMuffinsCookies;
    static long maxC;
    static long maxM;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            r.readLine();
            //input
            st = new StringTokenizer(r.readLine());
            n = Integer.parseInt(st.nextToken());
            cTime = Long.parseLong(st.nextToken());
            mTime = Long.parseLong(st.nextToken());

            minMuffins = new long[n];
            minCookies = new long[n];
            minCookiesMuffins = new long[n];
            minMuffinsCookies = new long[n];
            maxC = 0;
            maxM = 0;

            for (int j = 0; j < n; j ++) {
                st = new StringTokenizer(r.readLine());
                long c = Long.parseLong(st.nextToken());
                long m = Long.parseLong(st.nextToken());
                long t = Long.parseLong(st.nextToken());
                Trio friend = new Trio(c, m, t);
                findMinC(friend, j);
                findMinM(friend, j);
            }

            long ans = 0;
            for (int j = 0; j < n; j ++) {
                ans = Math.max(ans, minCookies[j] + Math.max(minCookiesMuffins[j], maxM));
            }

            for (int j = 0; j < n; j ++) {
                ans = Math.max(ans, minMuffins[j] + Math.max(minMuffinsCookies[j], maxC));
            }
            System.out.println(ans);
        }
    }
    public static void findMinC(Trio friend, int j) {
        long min = 0; long max = cTime - 1;

        long m = 0;
        while (min < max) {
            long mid = min + (max - min) / 2;

            m = checkIfWorksC(friend, mid);

            if (m != -1) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        minCookies[j] = min;
        maxC = Math.max(maxC, min);
        minCookiesMuffins[j] = m;
    }
    public static void findMinM(Trio friend, int j) {
        long min = 0; long max = mTime - 1;

        long c = 0;

        while (min < max) {
            long mid = min + (max - min) / 2;

            c = checkIfWorksM(friend, mid);

            if (c != -1) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        minMuffins[j] = min;
        maxM = Math.max(maxM, min);
        minMuffinsCookies[j] = c;
    }
    public static long checkIfWorksM(Trio friend, long m) {
        long c = (long) Math.ceil((friend.m * mTime - friend.m * m + friend.c * cTime - friend.t) / (double) friend.c);

        if (c < 0) {
            return 0;
        }
        if (c < cTime) {
            return c;
        }
        return -1;
    }

    public static long checkIfWorksC(Trio friend, long c) {
        long m = (long) Math.ceil((friend.c * cTime - friend.c * c + friend.m * mTime - friend.t) / (double) friend.m);

        if (m < 0) {
            return 0;
        }
        if (m < mTime) {
            return m;
        }
        return -1;
    }
}
class Trio {
    long c;
    long m;
    long t;

    public Trio(long c, long m, long t) {
        this.c = c;
        this.m = m;
        this.t = t;
    }

    @Override
    public String toString() {
        return "{" + c + "," + m + "," + t + "}";
    }
}
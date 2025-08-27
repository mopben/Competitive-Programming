//originally used functions to generate the cows, but it timed out

import java.io.*;
import java.util.*;

public class TheGrandFarm-off {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static long A;
    static long B;
    static long C;
    static long D;
    static long E;
    static long F;
    static long G;
    static long H;
    static long M;
    static Cow[] cows;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        D = Long.parseLong(st.nextToken());
        E = Long.parseLong(st.nextToken());
        F = Long.parseLong(st.nextToken());
        G = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        cows = new Cow[N * 3];
        for (int i = 0; i < N * 3; i ++) {
            cows[i] = new Cow(i);
        }

        Arrays.sort(cows);

        long ans = 0;
        for (int i = 0; i < N; i ++) {
            ans += cows[i].weight;
        }
        pw.println(ans % M);
        pw.close();
    }
    static class Cow implements Comparable<Cow> {
        long weight;
        long utility;

        public Cow (long i) {
            //weight---------------------
            long a = A;
            for (int j = 0; j < 5; j ++) {
                a = (a * i) % D;
            }
            a %= D;

            long b = B;
            for (int j = 0; j < 2; j ++) {
                b = (b * i) % D;
            }
            b %= D;

            weight = (a + b + (C % D)) % D;

            //utility------------------------------
            long e = E;
            for (int j = 0; j < 5; j ++) {
                e = (e * i) % H;
            }
            e %= H;

            long f = F;
            for (int j = 0; j < 3; j ++) {
                f = (f * i) % H;
            }
            f %= H;

            utility = (e + f + (G % H)) % H;

        }
        @Override
        public int compareTo(Cow o) {
            if (utility == o.utility) {
                return Long.compare(weight, o.weight);
            }
            return -Long.compare(utility, o.utility);
        }
    }
}

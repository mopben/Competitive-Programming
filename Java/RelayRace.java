package com.company;

import java.io.*;
import java.util.*;

public class RelayRace {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static boolean[] ran;
    static int[] speed;
    static ArrayList<Integer>[] signals;
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(r.readLine());

        speed = new int[N];
        signals = new ArrayList[N];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            speed[i] = Integer.parseInt(st.nextToken());
            int numSignals = Integer.parseInt(st.nextToken());

            signals[i] = new ArrayList<>(numSignals);
            for (int j = 0; j < numSignals; j ++) {
                signals[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        ran = new boolean[N];
        pw.println(findTime());
        pw.close();

    }
    public static int findTime() {
        PriorityQueue<Pair> next = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.time));
        next.add(new Pair(0,speed[0]));

        ran[0] = true;
        int ans = 0;

        while (next.size() != 0) {
            int cow = next.peek().cow;
            int time = next.poll().time;
            ans = Math.max(ans, time);

            for (int i : signals[cow]) {
                if (!ran[i]) {
                    next.add(new Pair(i,time + speed[i]));
                    ran[i] = true;
                }
            }
        }
        return ans;
    }
}
class Pair {
    int cow;
    int time;

    public Pair(int first, int second) {
        cow = first;
        time = second;
    }
}
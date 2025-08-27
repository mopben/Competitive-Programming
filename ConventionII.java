import java.io.*;
import java.util.*;

public class ConventionII {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));

        // take inputs------------------------------------------------------------------------------
        int n = Integer.parseInt(r.readLine());

        int[][] cows = new int[n][2];
        TreeMap<Integer, TreeSet<Integer>> events = new TreeMap<>();
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            final int arrivalTime = Integer.parseInt(st.nextToken());
            final int timeSpent = Integer.parseInt(st.nextToken());

            cows[i][0] = arrivalTime;
            cows[i][1] = timeSpent;

            events.computeIfAbsent(arrivalTime, k -> new TreeSet<>());
            events.get(arrivalTime).add(i);
        }

        //solve----------------------------------------------------------------------------------
        int ans = 0;
        TreeSet<Integer> waitList = new TreeSet<>();
        boolean occupied = false;

        while (!events.isEmpty()) {
            final int time = events.firstKey();
            final TreeSet<Integer> arrivals = events.get(time);

            events.remove(time);
            waitList.addAll(arrivals);

            if (arrivals.contains(-1)) {
                occupied = false;
                waitList.remove(-1);
            }

            if (!occupied && !waitList.isEmpty()) {
                final int cow = waitList.pollFirst();
                occupied = true;
                ans = Math.max(ans, time - cows[cow][0]);
                events.computeIfAbsent(time + cows[cow][1], k -> new TreeSet<>());
                events.get(time + cows[cow][1]).add(-1);
            }
        }

        pw.println(ans);
        pw.close();
    }
}
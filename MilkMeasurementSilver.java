import java.io.*;
import java.util.*;

public class MilkMeasurementSilver {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        int[][] changes = new int[n][3];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(r.readLine());
            changes[i][0] = Integer.parseInt(st.nextToken());
            changes[i][1] = Integer.parseInt(st.nextToken());
            changes[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(changes, Comparator.comparingInt(k -> k[0]));

        //milk produced, amount of cows with that amount of milk produced
        TreeMap<Integer, HashSet<Integer>> counter = new TreeMap<>();
        //cow ID and milk produced
        HashMap<Integer, Integer> outputs = new HashMap<>();
        outputs.put(-1,g);
        counter.put(g,new HashSet<>());
        for (int i = -1; i >= -300_001; i --)
            counter.get(g).add(i);

        int lastMax = g;
        int lastCounter = 1;
        int lastCow = -1;
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            final int newProduction = outputs.getOrDefault(changes[i][1],g) + changes[i][2];
            outputs.put(changes[i][1], newProduction);
            counter.computeIfAbsent(newProduction, k -> new HashSet<>()).add(changes[i][1]);

            counter.get(newProduction - changes[i][2]).remove(changes[i][1]);
            if (counter.get(newProduction - changes[i][2]).size() <= 0)
                counter.remove(newProduction - changes[i][2]);

            final int maxProduction = counter.lastKey();
            if (maxProduction != lastMax && !(counter.get(maxProduction).contains(lastCow) && counter.get(maxProduction).size() == 1))
                ans ++;
            if (maxProduction == lastMax && lastCounter != counter.get(maxProduction).size())
                ans ++;

            lastMax = maxProduction;
            lastCounter = counter.get(maxProduction).size();
            lastCow = counter.get(maxProduction).size() == 1 ? counter.get(maxProduction).stream().findFirst().get() : -2;
        }

        pw.println(ans);
        pw.close();
    }
}
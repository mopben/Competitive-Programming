import java.io.*;
import java.util.*;

public class SnowBoots {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static TreeMap<Integer, HashSet<Integer>> snow;
    static TreeSet<Integer> tiles;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("snowboots.out"));
        
	StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        snow = new TreeMap<>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            snow.computeIfAbsent(Integer.parseInt(st.nextToken()), k -> new HashSet<>()).add(i);

        tiles = new TreeSet<>();
        for (int i = 0; i < n; i ++)
            tiles.add(i);

        int[][] boots = new int[b][3];
        for (int i = 0; i < b; i ++) {
            st = new StringTokenizer(r.readLine());
            final int maxDepth = Integer.parseInt(st.nextToken());
            final int maxStep = Integer.parseInt(st.nextToken());

            boots[i][0] = maxDepth;
            boots[i][1] = maxStep;
            boots[i][2] = i;
        }
        Arrays.sort(boots, Comparator.comparingInt(value -> value[0]));
        Collections.reverse(Arrays.asList(boots));

        int[] ans = new int[b];
        for (int i = 0; i < b; i ++) {
            removeInvalid(boots[i][0]);
            if (checkValid(boots[i][1]))
                ans[boots[i][2]] = 1;
        }
        for (int i : ans)
            pw.println(i);
        pw.close();
    }
    public static boolean checkValid(int maxStep) {
        int loc = 0;
        while (loc != n-1) {
            int next = tiles.floor(loc + maxStep);
            if (next == loc)
                return false;
            loc = next;
        }
        return true;
    }
    public static void removeInvalid(int maxDepth) {
        while (snow.lastKey() > maxDepth) {
            for (int j : snow.get(snow.lastKey()))
                tiles.remove(j);
            snow.remove(snow.lastKey());
        }
    }
}

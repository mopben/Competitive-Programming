import java.io.*;
import java.util.*;

public class CellularNetwork{

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> cities = new TreeSet<>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++)
            cities.add(Integer.parseInt(st.nextToken()));

        TreeSet<Integer> towers = new TreeSet<>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i ++)
            towers.add(Integer.parseInt(st.nextToken()));

        int ans = 0;
        for (int i : cities) {
            int lower = towers.lower(i+1) == null ? 2_100_000_000 : i - towers.lower(i+1);
            int higher = towers.higher(i-1) == null ? 2_100_000_000 : towers.higher(i-1) - i;
            ans = Math.max(ans,Math.min(lower,higher));
        }
        pw.println(ans);
        pw.close();
    }
}

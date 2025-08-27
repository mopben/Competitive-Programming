import java.io.*;
import java.util.*;

public class Cowlendar {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    static HashMap<Long, Long> multiset = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());

        long[] days = new long[n];
        long maxDay = 0;
        HashSet<Long> distinctNumbers = new HashSet<>();
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i ++) {
            days[i] = Long.parseLong(st.nextToken());
            maxDay = Math.max(days[i], maxDay);
            distinctNumbers.add(days[i]);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (Math.abs(days[i] - days[j]) <= maxDay / 4) {
                    findDivisors(Math.abs(days[i] - days[j]));
                }
            }
        }
        int distinct = distinctNumbers.size();

        long ans = 0;
        for (long num : multiset.keySet()) {
            if (multiset.get(num) >= 3 - distinct) {
                ans += num;
            }
        }

        if (distinct <= 3) {
            long temp = maxDay / 4;
            ans = ((long) temp * (temp + 1)) / 2;
        }

        System.out.println(ans);
    }
    public static void findDivisors(long num) {
        for (int i = 1; i <= Math.sqrt(num); i ++) {
            if (num % i == 0) {
                add(i);
            }
        }
        add(num);
    }
    static void add(long x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        }
        else {
            multiset.put(x, 1L);
        }
    }
}

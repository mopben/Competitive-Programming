import java.io.*;
import java.util.*;

public class DoYouKnowYourABCsSilver {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        final int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            final int N = Integer.parseInt(r.readLine());

            StringTokenizer st = new StringTokenizer(r.readLine());

            List<Integer> numbers = new ArrayList<>(N);
            for (int j = 0; j < N; j ++) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            int ans = 0;
            HashSet<Integer> possibilities = new HashSet<>();
            for (int j : numbers) {
                possibilities.add(j);
                for (int k : numbers) {
                    if (k > j) {
                        possibilities.add(k - j);
                    }
                }
            }
            for (int a : possibilities) {
                for (int b : possibilities) {
                    for (int c : possibilities) {
                        if (a <= b && b <= c) {
                            HashSet<Integer> needContains = new HashSet<>(Arrays.asList(a, b, c, a + b, b + c, c + a, a + b + c));
                            if (needContains.containsAll(numbers)) {
                                ans ++;
                            }
                        }
                    }
                }
            }
            pw.println(ans);
        }
        pw.close();

    }
}

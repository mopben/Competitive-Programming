import java.io.*;
import java.util.*;

public class HighCardWins {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("highercard.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("highercard.in"));

        int N = Integer.parseInt(r.readLine());

        HashSet<Integer> elsie = new HashSet<>();

        for (int i = 0; i < N; i ++) {
            elsie.add(Integer.parseInt(r.readLine()));
        }

        TreeSet<Integer> bessie = new TreeSet<>();
        for (int i = 1; i <= 2 * N; i ++) {
            if (!elsie.contains(i)) {
                bessie.add(i);
            }
        }

        int ans = 0;
        for (int i : elsie) {
            if (bessie.ceiling(i) != null) {
                ans ++;
                bessie.remove(bessie.ceiling(i));
            }
        }
        pw.println(ans);
        pw.close();
    }
}

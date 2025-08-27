import java.io.*;
import java.util.*;

public class HighCardLowCard_Gold {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cardgame.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));

        int n = Integer.parseInt(r.readLine());

        TreeSet<Integer> firstHalf = new TreeSet<>();
        for (int i = 0; i < n / 2; i ++)
            firstHalf.add(Integer.parseInt(r.readLine()));

        TreeSet<Integer> secondHalf = new TreeSet<>();
        for (int i = 0; i < n / 2; i ++)
            secondHalf.add(Integer.parseInt(r.readLine()));

        int[] bessie = new int[n];
        int index = 0;
        for (int i = 2 * n; i > 0; i --) {
            if (!firstHalf.contains(i) && !secondHalf.contains(i)) {
                bessie[index] = i;
                index ++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n / 2; i ++) {
            int matchUp = firstHalf.lower(bessie[i]) == null ? -1 : firstHalf.lower(bessie[i]);
            if (matchUp != -1) {
                ans ++;
                firstHalf.remove(firstHalf.lower(bessie[i]));
            }
        }
        for (int i = n/2; i < n; i ++) {
            int matchUp = secondHalf.higher(bessie[i]) == null ? -1 : secondHalf.higher(bessie[i]);
            if (matchUp != -1) {
                ans ++;
                secondHalf.remove(secondHalf.higher(bessie[i]));
            }
        }
        pw.println(ans);
        pw.close();
    }
}
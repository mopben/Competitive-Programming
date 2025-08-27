import java.io.*;
import java.util.*;

public class AngryCowsGold {

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static int n;
    static TreeSet<Integer> bales;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));

        n = Integer.parseInt(r.readLine());

        bales = new TreeSet<>();
        for (int i = 0; i < n; i ++)
            bales.add(Integer.parseInt(r.readLine()) * 2);

        int lowR = 0; int highR = 1_000_000_000;
        while (lowR != highR) {
            int radius = (lowR + highR) / 2;

            int lowP = bales.first(); int highP = bales.last();
            while (lowP < highP) {
                int pos = (lowP + highP + 1) / 2;
                if (checkPossibleFirst(radius, pos))
                    lowP = pos;
                else
                    highP = pos - 1;
            }
            if (checkPossibleLast(radius, lowP))
                highR = radius;
            else
                lowR = radius + 1;
        }
        pw.printf("%.1f\n", highR / 2.0);
        pw.close();
    }
    //check if possible to explode first bale given starting pos and radius

    public static boolean checkPossibleFirst(int r, int pos) {
        if (bales.first() > pos - r)
            return true;

        pos = bales.ceiling(pos - r);
        r -= 2;
        while (pos != bales.first()) {
            int next = bales.ceiling(pos - r);
            if (next >= pos)
                return false;
            pos = next;
            r -= 2;
        }
        return true;
    }

    public static boolean checkPossibleLast(int r, int pos) {
        if (bales.last() < pos + r)
            return true;

        pos = bales.floor(pos + r);
        r -= 2;
        while (pos != bales.last()) {
            int next = bales.floor(pos + r);
            if (next <= pos)
                return false;
            pos = next;
            r -= 2;
        }
        return true;
    }
}


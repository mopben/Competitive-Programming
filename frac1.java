/*
ID: benqia51
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("frac1.in"));
            pw = new PrintWriter(new FileWriter("frac1.out"));

        } catch(IOException e) {}
    }
     
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        HashSet<Double> seen = new HashSet<>();
        HashMap<Double, int[]> ans = new HashMap<>();

        for (int denominator = 1; denominator <= n; denominator ++) {
            for (int numerator = 0; numerator <= denominator; numerator ++) {
                double quotient = numerator * 1.0 / denominator;
                if (!seen.contains(quotient)) {
                    seen.add(quotient);
                    int gcd = findgcd(numerator, denominator);
                    ans.put(quotient,new int[]{numerator / gcd, denominator / gcd});
                }
            }
        }
        List<Double> sortedSeen = new ArrayList<>(seen);
        sortedSeen.sort(Comparator.comparingDouble(value -> value));
        for (Double i : sortedSeen)
            pw.println(ans.get(i)[0] + "/" + ans.get(i)[1]);
        pw.close();

    }
    public static int findgcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return findgcd(n2, n1 % n2);
    }
}
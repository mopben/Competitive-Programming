/*
ID: benqia51
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("hamming.in"));
            pw = new PrintWriter(new FileWriter("hamming.out"));

        } catch(IOException e) {}
    }


    static int n;
    static int b;
    static int d;
    static ArrayList<Integer> words;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        words = new ArrayList<>(Arrays.asList(0));
        solve(0);

        for (int i = 1; i <= n; i ++) {
            pw.print(words.get(i-1));

            if (i % 10 == 0)
                pw.println();

            else if (i != n)
                pw.print(" ");
        }
	if (n % 10 != 0)
		pw.println();
        pw.close();
    }
    public static void solve( int last) {
        if (words.size() >= n)
            return;

        int i = last;
        while (true) {
            boolean valid = true;
            for (int j : words) {
                if (findHammingDistance(i,j) < d) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                words.add(i);
                solve(i);
                break;
            }
            i ++;
        }

    }

    public static int findHammingDistance(int n1, int n2) {
        String a = Integer.toBinaryString(n1);
        String b = Integer.toBinaryString(n2);

        int counter = 0;
        for (int i = 1; i <= Math.max(a.length(),b.length()); i ++) {
            char ind1 = a.length() - i < 0 ? '0' : a.charAt(a.length() - i);
            char ind2 = b.length() - i < 0 ? '0' : b.charAt(b.length() - i);
            if (ind1 != ind2)
                counter ++;
        }
        return counter;
    }
}
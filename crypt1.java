/*
ID: benqia51
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;

public class crypt1{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("crypt1.in"));
            pw = new PrintWriter(new FileWriter("crypt1.out"));

        } catch(IOException e) {}
    }

     


    static HashSet<Integer> digits;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        digits = new HashSet<>();
        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < n; i ++) {
            digits.add(Integer.parseInt(st.nextToken()));
        }
        int p1;
        int p2;
        int sum;
        int ans = 0;
        for (int i1 : digits) {
            for (int i2: digits) {
                for (int i3: digits) {
                    for(int j1 : digits) {
                        for (int j2 : digits) {
                            p1 = ((i1 * 100) + (i2 * 10) + i3) * j1;
                            p2 = ((i1 * 100) + (i2 * 10) + i3) * j2;
                            sum = p1 + p2 * 10;
                            if (checkProduct(p1) && checkProduct(p2) && checkSum(sum))
                                ans ++;
                        }
                    }
                }
            }
        }
        pw.println(ans);
        pw.close();

    }
    public static boolean checkProduct(int val) {
        String s = Integer.toString(val);
        if (s.length() == 3)
            return digits.contains(Character.getNumericValue(s.charAt(0))) && digits.contains(Character.getNumericValue(s.charAt(1))) && digits.contains(Character.getNumericValue(s.charAt(2)));
        return false;
    }

    public static boolean checkSum(int val) {
        String s = Integer.toString(val);
        if (s.length() == 4)
            return digits.contains(Character.getNumericValue(s.charAt(0))) && digits.contains(Character.getNumericValue(s.charAt(1))) && digits.contains(Character.getNumericValue(s.charAt(2))) && digits.contains(Character.getNumericValue(s.charAt(3)));
        return false;
    }

}
/*
ID: benqia51
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

public class sprime{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("sprime.in"));
            pw = new PrintWriter(new FileWriter("sprime.out"));

        } catch(IOException e) {}
    }

     
    static int[] primeTest;
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(r.readLine());
        primeTest = new int[]{1,3,7,9};
        solve(2,n);
        solve(3,n);
        solve(5,n);
        solve(7,n);
        solve(9,n);
        pw.close();
    }

    public static void solve(int num, int digit) {
        if (checkPrime(num)) {
            if (digit == 1)
                pw.println(num);

            else {
                for (int i : primeTest) {
                    String temp = Integer.toString(num);
                    temp = temp + i;
                    solve(Integer.parseInt(temp),digit - 1);
                }
            }
        }
    }
    public static boolean checkPrime(int num) {
        if (num == 3 || num == 2)
            return true;

        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
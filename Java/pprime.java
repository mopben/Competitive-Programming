/*
ID: benqia51
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

public class pprime{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("pprime.in"));
            pw = new PrintWriter(new FileWriter("pprime.out"));

        } catch(IOException e) {}
    }

     


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> palindromes = generatePalindromes(1);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }

        palindromes = generatePalindromes(2);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }


        palindromes = generatePalindromes(3);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }

        palindromes = generatePalindromes(4);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }

        palindromes = generatePalindromes(5);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }
        palindromes = generatePalindromes(6);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }

        palindromes = generatePalindromes(7);
        for (int i : palindromes) {
            if (checkPrime(i) && i >= a && i <= b)
                pw.println(i);
        }

        pw.close();
    }
    public static List<Integer> generatePalindromes(int digits) {
        List<Integer> palindromes = new ArrayList<>();

        if (digits == 1)
            palindromes.addAll(Arrays.asList(5,7));

        if (digits == 2) {
            for (int i = 1; i <= 9; i += 2) {
                palindromes.add(i * 10 + i);
            }
        }

        if (digits == 3) {
            for (int i = 1; i <= 9; i += 2) {
                for (int j = 0; j <= 9; j ++) {
                    palindromes.add(i * 100 + j * 10 + i );
                }
            }
        }

        if (digits == 4) {
            for (int i = 1; i <= 9; i += 2) {
                for (int j = 0; j <= 9; j ++) {
                    palindromes.add(1000 * i + 100 * j + 10 * j + i);
                }
            }
        }

        if (digits == 5) {
            for (int i = 1; i <= 9; i += 2) {
                for (int j = 0; j <= 9; j ++ ) {
                    for (int k = 0; k <= 9; k ++) {
                        palindromes.add(10000 * i + 1000 * j + 100 * k + 10 * j + i);
                    }
                }
            }
        }
        if (digits == 6) {
            for (int i = 1; i <= 9; i += 2) {
                for (int j = 0; j <= 9; j ++ ) {
                    for (int k = 0; k <= 9; k ++ ) {
                        palindromes.add(100000 * i + 10000 * j + 1000 * k + 100 * k + 10 * j + i);
                    }
                }
            }
        }
        if (digits == 7) {
            for (int i = 1; i <= 9; i += 2) {
                for (int j = 0; j <= 9; j ++) {
                    for (int k = 0; k <= 9; k ++) {
                        for (int a = 0; a <= 9; a ++) {
                            palindromes.add(1000000 * i + 100000 * j + 10000 * k + 1000 * a + 100 * k + 10 * j + i);
                        }
                    }
                }
            }
        }

        return palindromes;
    }
    public static boolean checkPrime(int num) {
        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
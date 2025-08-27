/*
ID: benqia51
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("preface.in"));
            pw = new PrintWriter(new FileWriter("preface.out"));

        } catch(IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        int[] ans = new int[7];
        char[] numerals = {'I', 'V','X','L','C','D','M'};

        for (int i = 1; i <= n; i ++) {
            int[] counter = convert(i);
            for (int j = 0; j < 7; j ++)
                ans[j] += counter[j];
        }

        for (int i = 0; i < 7; i ++) {
            if (ans[i] != 0)
                pw.println(numerals[i] + " " + ans[i]);
        }
        pw.close();
    }
    public static int[] convert(int num) {
        int[] counter = new int[7];
        while(num >= 1000) {
            num -= 1000;
            counter[6] ++;
        }
        while(num >= 900) {
            num -= 900;
            counter[6]++;
            counter[4]++;
        }
        while (num >= 500) {
            num -= 500;
            counter[5] ++;
        }
        while (num >= 400) {
            num -= 400;
            counter[5] ++;
            counter[4] ++;
        }
        while (num >= 100) {
            num -= 100;
            counter[4] ++;
        }
        while (num >= 90) {
            num -= 90;
            counter[4] ++;
            counter[2] ++;
        }
        while (num >= 50) {
            num -= 50;
            counter[3] ++;
        }
        while (num >= 40) {
            num -= 40;
            counter[3] ++;
            counter[2] ++;
        }
        while (num >= 10) {
            num -= 10;
            counter[2] ++;
        }
        while (num >= 9) {
            num -= 9;
            counter[2] ++;
            counter[0] ++;
        }
        while (num >=5) {
            num -= 5;
            counter[1] ++;
        }
        while(num >= 4) {
            num -= 4;
            counter[1] ++;
            counter[0] ++;
        }
        while (num >= 1) {
            num -= 1;
            counter[0] ++;
        }
        return counter;
    }
}
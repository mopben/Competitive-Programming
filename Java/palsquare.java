/*
ID: benqia51
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

public class palsquare{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("palsquare.in"));
            pw = new PrintWriter(new FileWriter("palsquare.out"));

        } catch(IOException e) {}
    }

     

    static int base;
    static HashMap<Integer, String> converter;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        base = Integer.parseInt(st.nextToken());
        converter = new HashMap<>();
        converter.put(10, "A");
        converter.put(11, "B");
        converter.put(12, "C");
        converter.put(13, "D");
        converter.put(14, "E");
        converter.put(15, "F");
        converter.put(16, "G");
        converter.put(17, "H");
        converter.put(18, "I");
        converter.put(19, "J");
        for (int i = 1; i < 300; i ++){
            if (check(i)) {
                pw.println(convert(i) + " " + convert(i * i));
            }
        }
        pw.close();
    }
    public static boolean check(int num){
        return convert(num * num).equals(new StringBuffer(convert(num * num)).reverse().toString());
    }

    public static String convert(int num) {
        int result = -1;
        String newNum = "";

        while (result != 0){
            result = num / base;
            int remainder = num % base;
            num = result;
            if (remainder >= 10)
                newNum = converter.get(remainder) + newNum;
            else
                newNum = remainder + newNum;
        }

        if (newNum.equals(""))
            return "asdfghjkl";
        return newNum;
    }
}
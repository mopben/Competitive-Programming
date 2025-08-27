/*
ID: benqia51
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;

public class namenum{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    static BufferedReader r;
    static BufferedReader txt;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("namenum.in"));
            txt = new BufferedReader(new FileReader("dict.txt"));
            pw = new PrintWriter(new FileWriter("namenum.out"));

        } catch(IOException e) {}
    }


    static char[] n;
    static HashSet<String> valid;
    static HashMap<Character, TreeSet<Character>> mapping;
    static int counter;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = st.nextToken().toCharArray();
        valid = new HashSet<>();

        while (txt.ready()) {
            st = new StringTokenizer(txt.readLine());
            valid.add(st.nextToken());
        }

        mapping = new HashMap<>();
        mapping.put('2', new TreeSet<>(Arrays.asList('A','B','C')));
        mapping.put('3', new TreeSet<>(Arrays.asList('D','E','F')));
        mapping.put('4', new TreeSet<>(Arrays.asList('G','H','I')));
        mapping.put('5', new TreeSet<>(Arrays.asList('J','K','L')));
        mapping.put('6', new TreeSet<>(Arrays.asList('M','N','O')));
        mapping.put('7', new TreeSet<>(Arrays.asList('P','R','S')));
        mapping.put('8', new TreeSet<>(Arrays.asList('T','U','V')));
        mapping.put('9', new TreeSet<>(Arrays.asList('W','X','Y')));
        
        counter = 0;
        solve("",0);
        
        if (counter == 0)
            pw.println("NONE");
        pw.close();
    }
    public static void solve(String name, int ind) {
        if (ind == n.length){
            if (valid.contains(name)) {
                counter ++;
                pw.println(name);
            }
        }
        else{
            for (char i : mapping.get(n[ind])) {
                solve(name + i, ind + 1);
            }
        }
    }

}
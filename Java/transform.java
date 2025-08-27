/*
ID: benqia51
LANG: JAVA
TASK: transform
*/

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class transform{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;
    static {
        try {
            r = new BufferedReader(new FileReader("transform.in"));
            pw = new PrintWriter(new FileWriter("transform.out"));
        } catch(IOException e) {}
    }

     

    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        char[][] before = new char[n][n];
        char[][] after = new char[n][n];
        for (int i = 0; i < n; i ++){
            before[i] = r.readLine().toCharArray();
        }

        for (int i = 0; i < n; i ++){
            after[i] = r.readLine().toCharArray();
        }
        pw.println(solve(before,after));
        pw.close();
    }
    public static char[][] rotate90(char[][] arr) {
        char[][] newArr = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                newArr[j][n - i - 1] = arr[i][j];

            }
        }
        return newArr;
    }
    public static char[][] reflect(char[][] arr) {
        char[][] newArr = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++){
                newArr[i][j] = arr[i][n - j - 1];
            }
        }
        return newArr;
    }
    public static int solve(char[][] start, char[][] goal){
        if (Arrays.deepEquals(rotate90(start), goal))
            return 1;
        if (Arrays.deepEquals(rotate90(rotate90(start)), goal))
            return 2;
        if (Arrays.deepEquals(rotate90(rotate90(rotate90(start))), goal))
            return 3;
        if (Arrays.deepEquals(reflect(start), goal))
            return 4;
        if (Arrays.deepEquals(rotate90(reflect(start)), goal) || Arrays.deepEquals(rotate90(rotate90(reflect(start))), goal) || Arrays.deepEquals(rotate90(rotate90(rotate90(reflect(start)))), goal))
            return 5;
        if (start == goal)
            return 6;

        return 7;
    }
}
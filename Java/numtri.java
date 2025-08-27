/*
ID: benqia51
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;

/*
ID: benqia51
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;

public class numtri{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("numtri.in"));
            pw = new PrintWriter(new FileWriter("numtri.out"));

        } catch(IOException e) {}
    }

     
    static int n;
    static int[][] triangle;
    static int[][] val;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(r.readLine());

        triangle = new int[n+1][n+1];
        val = new int[n+1][n+1];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            for (int j = 0; j < i + 1; j++) {
                val[i][j] = -1;
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pw.println(solve(0,0));
        pw.close();
    }
    public static int solve(int col, int row) {
        if (val[col][row] != -1)
            return val[col][row];

        if (col <= n)
            return val[col][row] = triangle[col][row] + Math.max(solve(col + 1, row), solve(col + 1, row + 1));
        else
            return 0;
    }
}
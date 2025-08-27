/*
ID: benqia51
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("holstein.in"));
            pw = new PrintWriter(new FileWriter("holstein.out"));

        } catch(IOException e) {}
    }

     
    public static void main(String[] args) throws IOException {
        int v = Integer.parseInt(r.readLine());
        int[] cow = new int[v];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < v; i ++)
            cow[i] = Integer.parseInt(st.nextToken());

        int g = Integer.parseInt(r.readLine());
        int[][] feed = new int[g][v];
        for (int i = 0; i < g; i ++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < v; j ++)
                feed[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] indices = new int[g];
        for (int i = 0; i < g; i ++)
            indices[i] = i;

        for (int i = 1; i <= g; i ++) {
            for (ArrayList<Integer> j: combinations(indices,i)) {
                int[] sum = new int[v];
                boolean works = true;
                for (int k = 0; k < i; k ++) {
                    for (int a = 0; a < v; a++) {
                        sum[a] += feed[j.get(k)][a];
                    }
                }
                for (int k = 0; k < v; k ++) {
                    if (sum[k] < cow[k]) {
                        works = false;
                        break;
                    }
                }
                if (works) {
                    j.sort(Comparator.comparingInt(value -> value));
                    pw.print(i + " ");
                    for (int k = 0; k < i; k ++) {
                        pw.print(j.get(k) + 1);
                        if (k != i-1)
                            pw.print(" ");
                    }
                    pw.println();
                    pw.close();
                    System.exit(0);
                }
            }
        }
        pw.close();
    }
    public static ArrayList<ArrayList<Integer>> combinations(int[] arr, int r) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        int n = arr.length;
        int[] indices = new int[r];

        for (int i = 0; i < r; i++)
            indices[i] = i;

        ArrayList<Integer> pair = new ArrayList<>();
        for (int i : indices) {
            pair.add(arr[i]);
        }
        combinations.add(pair);

        int lastI = 0;
        boolean broke;
        while (true) {
            broke = false;
            for (int i = r - 1; i >= 0; i--) {
                lastI = i;
                if (indices[i] != i + n - r) {
                    broke = true;
                    break;
                }
            }
            if (!broke)
                return combinations;

            indices[lastI]++;
            for (int i = lastI + 1; i < r; i++)
                indices[i] = indices[i - 1] + 1;

            pair = new ArrayList<>();
            for (int i : indices) {
                pair.add(arr[i]);
            }
            combinations.add(pair);
        }
    }
}
/*
ID: benqia51
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

public class sort3{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("sort3.in"));
            pw = new PrintWriter(new FileWriter("sort3.out"));

        } catch(IOException e) {}
    }

     

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        int[] sequence = new int[n];
        int[] counter = new int[3];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(r.readLine());
            counter[sequence[i] - 1]++;
        }
        int[] sortedSeq = sequence.clone();
        Arrays.sort(sortedSeq);

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j++) {
                if (sortedSeq[i] == sequence[j] && sortedSeq[j] == sequence[i] && sequence[i] != sequence[j]) {
                    ans++;
                    swap(sequence, i, j);
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            if (sequence[i] != sortedSeq[i]) {
                for (int j = 0; j < n; j ++) {
                    if (sortedSeq[j] == sequence[i] && sequence[j] != sequence[i]) {
                        swap(sequence,i,j);
                        ans ++;
                    }
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    public static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}
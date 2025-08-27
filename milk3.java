/*
ID: benqia51
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

public class milk3{

    //static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //static PrintWriter pw = new PrintWriter(System.out);

    
    static BufferedReader r;
    static PrintWriter pw;

    static {
        try {
            r = new BufferedReader(new FileReader("milk3.in"));
            pw = new PrintWriter(new FileWriter("milk3.out"));

        } catch(IOException e) {}
    }

     
    static HashSet<List<Integer>> seen;
    static int[] capacity;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        capacity = new int[3];
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());
        seen = new HashSet<>();

        ans = new ArrayList<>();

        solve(new int[]{0,0,capacity[2]});
        ans.sort(Comparator.comparingInt(value -> value));
        for (int i = 0; i < ans.size(); i ++) {
            pw.print(ans.get(i));
            if (i != ans.size()-1)
                pw.print(" ");
        }
        pw.println();

        pw.close();
    }
    public static void solve(int[] val) {

        seen.add(Arrays.asList(val[0],val[1]));

        if (val[0] == 0) {
            ans.add(val[2]);
        }


        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                int[] temp = pour(val.clone(),i,j);
                if (!seen.contains(Arrays.asList(temp[0],temp[1])))
                    solve(temp);

            }
        }
    }

    public static int[] pour(int[] milk,int give, int receive) {
        int minus = Math.min(milk[give],capacity[receive] - milk[receive]);
        milk[receive] += minus;
        milk[give] -= minus;
        return milk;
    }
}